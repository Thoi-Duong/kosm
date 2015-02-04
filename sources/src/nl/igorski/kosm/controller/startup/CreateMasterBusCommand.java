package nl.igorski.kosm.controller.startup;

import nl.igorski.lib.audio.factories.ProcessorFactory;
import nl.igorski.lib.audio.nativeaudio.Compressor;
import nl.igorski.lib.audio.nativeaudio.NativeAudioEngine;
import nl.igorski.lib.audio.nativeaudio.ProcessingChain;
import nl.igorski.lib.framework.controller.BaseSimpleCommand;
import nl.igorski.lib.framework.interfaces.INotification;
import nl.igorski.lib.utils.debugging.DebugTool;
import nl.igorski.kosm.audio.MWProcessingChain;
import nl.igorski.kosm.view.ParticleSequencer;

/**
 * Created with IntelliJ IDEA.
 * User: igorzinken
 * Date: 04-11-14
 * Time: 20:33
 * To change this template use File | Settings | File Templates.
 */
public final class CreateMasterBusCommand extends BaseSimpleCommand
{
    @Override
    public void execute( INotification aNote )
    {
        DebugTool.log( "CREATE MASTER BUS COMMAND" );

        final ProcessingChain chain = NativeAudioEngine.getMasterBusProcessors();
        ParticleSequencer.masterBus = new MWProcessingChain( chain );

        // compressor

        final Compressor compressor = ProcessorFactory.createCompressor( ParticleSequencer.masterBus );
        ParticleSequencer.masterBus.compressorActive = true;

        compressor.setThreshold( -34f );
        compressor.setRatio    ( .92f );

        // limiter
        ProcessorFactory.createFinalizer  ( ParticleSequencer.masterBus );
        ParticleSequencer.masterBus.finalizerActive = true;

        // filter
        ProcessorFactory.createLPFHPFilter( ParticleSequencer.masterBus );
        ParticleSequencer.masterBus.lpfHpfActive = true;

        ParticleSequencer.masterBus.cacheActiveProcessors();
        
        super.execute( aNote );
    }
}
