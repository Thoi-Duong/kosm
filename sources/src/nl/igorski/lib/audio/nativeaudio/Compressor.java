/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package nl.igorski.lib.audio.nativeaudio;

public class Compressor extends BaseProcessor {
  private long swigCPtr;

  protected Compressor(long cPtr, boolean cMemoryOwn) {
    super(NativeAudioEngineJNI.Compressor_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Compressor obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        NativeAudioEngineJNI.delete_Compressor(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public Compressor(float aThreshold, float aAttack, float aRelease, float aRatio) {
    this(NativeAudioEngineJNI.new_Compressor(aThreshold, aAttack, aRelease, aRatio), true);
  }

  public void process(SWIGTYPE_p_AudioBuffer sampleBuffer, boolean isMonoSource) {
    NativeAudioEngineJNI.Compressor_process(swigCPtr, this, SWIGTYPE_p_AudioBuffer.getCPtr(sampleBuffer), isMonoSource);
  }

  public boolean isCacheable() {
    return NativeAudioEngineJNI.Compressor_isCacheable(swigCPtr, this);
  }

  public float getAttack() {
    return NativeAudioEngineJNI.Compressor_getAttack(swigCPtr, this);
  }

  public void setAttack(float value) {
    NativeAudioEngineJNI.Compressor_setAttack(swigCPtr, this, value);
  }

  public float getRelease() {
    return NativeAudioEngineJNI.Compressor_getRelease(swigCPtr, this);
  }

  public void setRelease(float value) {
    NativeAudioEngineJNI.Compressor_setRelease(swigCPtr, this, value);
  }

  public float getThreshold() {
    return NativeAudioEngineJNI.Compressor_getThreshold(swigCPtr, this);
  }

  public void setThreshold(float value) {
    NativeAudioEngineJNI.Compressor_setThreshold(swigCPtr, this, value);
  }

  public float getRatio() {
    return NativeAudioEngineJNI.Compressor_getRatio(swigCPtr, this);
  }

  public void setRatio(float value) {
    NativeAudioEngineJNI.Compressor_setRatio(swigCPtr, this, value);
  }

  public void setSampleRate(int aSampleRate) {
    NativeAudioEngineJNI.Compressor_setSampleRate(swigCPtr, this, aSampleRate);
  }

  public final static int THRESHOLD_MAX_NEGATIVE_VALUE = NativeAudioEngineJNI.Compressor_THRESHOLD_MAX_NEGATIVE_VALUE_get();
  public final static int THRESHOLD_MAX_POSITIVE_VALUE = NativeAudioEngineJNI.Compressor_THRESHOLD_MAX_POSITIVE_VALUE_get();
}