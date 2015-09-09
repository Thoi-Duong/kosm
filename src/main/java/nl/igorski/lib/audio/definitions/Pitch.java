package nl.igorski.lib.audio.definitions;

import nl.igorski.lib.audio.vo.VOPitch;

/**
 * Created by IntelliJ IDEA.
 * User: igorzinken
 * Date: 4/12/12
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public final class Pitch
{
    /**
     *  initial variables set @ 4th octave where "middle C" resides
     *  these are used for calculating requested notes, we differentiate
     *  between whole-notes and enharmonic notes by using 'sharp' ( while
     *  these might not be "musically correct" in regard to scales and theory,
     *  the returned frequencies are the same!
     *
     *  note: we calculate from the 4th octave as way of moving from "center"
     *  pitches outward ( to lower / higher ranges ) as the changes in Hz feature
     *  slight deviations, which would become more apparent by calculating powers of n.
      */

    public static final double C                = 261.626;
    public static final double C_SHARP          = 277.183;
    public static final double D                = 293.665;
    public static final double D_SHARP          = 311.127;
    public static final double E                = 329.628;
    public static final double F                = 349.228;
    public static final double F_SHARP          = 369.994;
    public static final double G                = 391.995;
    public static final double G_SHARP          = 415.305;
    public static final double A                = 440;
    public static final double A_SHARP          = 466.164;
    public static final double B                = 493.883;

    public static final double[] OCTAVE         = { C, C_SHARP, D, D_SHARP, E, F, F_SHARP, G, G_SHARP, A, A_SHARP, B };
    public static final String[] OCTAVE_SCALE   = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };

    public static final String FLAT             = "b";
    public static final String SHARP            = "#";

    /* public */

    /**
     * generates the frequency in Hz corresponding to the given note at the given octave
     *
     * @param aNote   {String} musical note to return ( A, B, C, D, E, F, G with
     *                possible enharmonic notes ( 'b' meaning 'flat', '#' meaning 'sharp' )
     *                NOTE: flats are CASE sensitive ( to prevent seeing the note 'B' instead of 'b' )
     * @param aOctave {int} the octave to return ( accepted range 0 - 9 )
     *
     * @return {double} frequency in Hz for the requested note
     */
    public static double note( String aNote, int aOctave )
    {
        int i;
        double freq;
        int enharmonic = 0;
        aNote = aNote.toUpperCase();

        // detect flat enharmonic
        i = aNote.indexOf( FLAT );
        if ( i > -1 )
        {
            aNote = aNote.substring( i - 1, 1 );
            enharmonic = -1;
        }
        // detect sharp enharmonic
        i = aNote.indexOf( SHARP );
        if ( i > -1 )
        {
            aNote = aNote.substring( i - 1, 1 );
            enharmonic = 1;
        }
        freq = getOctaveIndex( aNote, enharmonic );

        if ( aOctave == 4 )
        {
            return freq;
        }
        else
        {
            // translate the pitches to the requested octave
            int d = aOctave - 4;
            int j = Math.abs( d );

            for ( i = 0; i < j; ++i )
            {
                if ( d > 0 )
                    freq *= 2;
                else
                    freq *= .5;
            }
            return freq;
        }
    }

    /**
     * takes a frequency in Hz and returns the pitch, octave and cents off the perfect center
     *
     * @param frequency {double}
     * @return {VOPitch}
     */
    public static VOPitch pitchByFrequency( double frequency )
    {
        String theNote  = "";

        final double lnote = ( Math.log( frequency ) - Math.log( 261.626 )) / Math.log( 2 ) + 4.0;
        double theOctave   = Math.floor( lnote );
        double theCents    = 1200 * ( lnote - theOctave );

        final String note_table = "C C#D D#E F F#G G#A A#B";
        double offset           = 50.0;
        int x                   = 2;

        if ( theCents < 50 ) {
            theNote = "C ";
        }
        else if ( theCents >= 1150 )
        {
            theNote = "C ";
            theCents -= 1200;
            ++theOctave;
        }
        else
        {
            for ( int j = 1; j <= 11 ; ++j )
            {
                if ( theCents >= offset && theCents < ( offset + 100 ))
                {
                    theNote = Character.toString( note_table.charAt( x ));

                    if (( x + 1 ) < note_table.length())
                        theNote += Character.toString( note_table.charAt( x + 1 ));

                    theCents -= ( j * 100 );
                    break;
                }
                offset += 100;
                x += 2;
            }
        }
        return new VOPitch( theNote.replace( " ", "" ), ( int ) theOctave, theCents );
    }

    /**
     * convert a frequency in Hz to the MIDI note number
     * @param aFrequency {double} the frequency in Hz
     * @return {int} MIDI note number
     */
    public static int frequencyToMIDINote( double aFrequency )
    {
        double r       = 1.05946309436;
        double ref     = 523.251;
        int    supinf  = 0;
        int    i       = 0;
        double hautnb  = 1;
        double ref1    = 0;
        double ref2    = 0;
        double flag    = 0;
        int    nmidi   = 72;

        while ( aFrequency < ref )
        {
            ref    = Math.floor( 1000 * ref / r ) / 1000;
            i      = i + 1;
            supinf = -1;
            flag   = 1;
            ref1   = ref;
        }

        while ( aFrequency > ref )
        {
            ref    = Math.floor( 1000 * ref * r ) / 1000;
            i      = i -1;
            supinf = 1;
            ref2   = ref;
        }

        if ( Math.abs( aFrequency - ref1 ) < Math.abs( aFrequency - ref2 ))
        {
            supinf = -1;
            i      = i +1;
        }
        else
        {
            if ( flag == 1 )
                supinf = -1;
        }

        if ( ref1 == 0 )
        {
            ref1 = Math.floor( 1000 * ref / r ) / 1000;

            if ( Math.abs( aFrequency - ref1 ) < Math.abs( aFrequency - ref2 ))
            {
                i  = i  + 1;
                supinf = 1;
            }
        }
        i  = Math.abs( i  );

        while ( i-- != 0 )
        {
            if (( hautnb == 1 && supinf == -1 ) || ( hautnb == 12 && supinf == 1 ))
            {
                if ( supinf == 1 )
                    hautnb = 0;

                if ( supinf == -1 )
                    hautnb = 13;
            }
            hautnb   = hautnb + supinf;
            nmidi    = nmidi + supinf;
        }
        return nmidi;
    }

    /* private */

    /**
     * retrieves the index in the octave array for a given note
     * modifier enharmonic returns the previous ( for a 'flat' note )
     * or next ( for a 'sharp' note ) index
     *
     * @param note        {String} ( A, B, C, D, E, F, G )
     * @param enharmonic  {int}    ( 0, -1 for flat, 1 for sharp )
     *
     * @return {double}
     */
    private static double getOctaveIndex( String note, int enharmonic )
    {
        int j = OCTAVE.length;

        for ( int i = 0; i < j; ++i )
        {
            if ( OCTAVE_SCALE[ i ].equals( note ))
            {
                int k = i + enharmonic;

                if ( k > j )
                    return OCTAVE[ 0 ];

                if ( k < 0 )
                    return OCTAVE[ OCTAVE.length - 1 ];

                return OCTAVE[ k ];
            }
        }
        return 0;
    }
}
