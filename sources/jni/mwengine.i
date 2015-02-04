/**
 * this file describes which native classes will
 * be made available to the Java using a SWIG wrapper
 * note the audio engine itself is not directly available
 * but only through javajni.h and sequencer_api.h
 */
%module NativeAudioEngine

%{
#include "javabridge_api.h"
#include "utilities/jnisamplemanager.h"
#include "adsr.h"
#include "arpeggiator.h"
#include "audiochannel.h"
#include "lfo.h"
#include "processingchain.h"
#include "processors/bitcrusher.h"
#include "processors/baseprocessor.h"
#include "processors/compressor.h"
#include "processors/decimator.h"
#include "processors/delay.h"
#include "processors/filter.h"
#include "processors/limiter.h"
#include "processors/finalizer.h"
#include "processors/fm.h"
#include "processors/formantfilter.h"
#include "processors/lpfhpfilter.h"
#include "processors/phaser.h"
#include "processors/pitchshifter.h"
#include "processors/waveshaper.h"
#include "utilities/bufferutility.h"
#include "utilities/bulkcacher.h"
#include "drumpattern.h"
#include "routeableoscillator.h"
#include "utilities/samplemanager.h"
#include "instruments/baseinstrument.h"
#include "instruments/druminstrument.h"
#include "instruments/synthinstrument.h"
#include "events/sampleevent.h"
#include "events/drumevent.h"
#include "events/basesynthevent.h"
#include "events/synthevent.h"
#include "sequencer_api.h"
#include "kosm/audioparticleevent.h"
%}

// Enable the JNI class to load the required native library.
%pragma(java) jniclasscode=%{
  static {
    try {
        java.lang.System.loadLibrary( "mwengine" );
    }
    catch ( UnsatisfiedLinkError e ) {
        java.lang.System.err.println( "mwengine native code library failed to load.\n" + e );
        java.lang.System.exit(1);
    }
  }
%}
%include carrays.i                 // enable passing of arrays via JNI
%array_functions(int, int_array)   // int arrays
%include "javabridge_api.h"
%include "utilities/jnisamplemanager.h"
%include "adsr.h"
%include "arpeggiator.h"
%include "audiochannel.h"
%include "lfo.h"
%include "processingchain.h"
%include "processors/baseprocessor.h"
%include "processors/bitcrusher.h"
%include "processors/compressor.h"
%include "processors/decimator.h"
%include "processors/delay.h"
%include "processors/filter.h"
%include "processors/limiter.h"
%include "processors/finalizer.h"
%include "processors/lpfhpfilter.h"
%include "processors/fm.h"
%include "processors/formantfilter.h"
%include "processors/phaser.h"
%include "processors/pitchshifter.h"
%include "processors/waveshaper.h"
%include "utilities/bufferutility.h"
%include "utilities/bulkcacher.h"
%include "drumpattern.h"
%include "routeableoscillator.h"
%include "utilities/samplemanager.h"
%include "instruments/baseinstrument.h"
%include "instruments/druminstrument.h"
%include "instruments/synthinstrument.h"
%include "events/baseaudioevent.h"
%include "events/basecacheableaudioevent.h"
%include "events/basesynthevent.h"
%include "events/sampleevent.h"
%include "events/drumevent.h"
%include "events/synthevent.h"
%include "sequencer_api.h"
%include "kosm/audioparticleevent.h"