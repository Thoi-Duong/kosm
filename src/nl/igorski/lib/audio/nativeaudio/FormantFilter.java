/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package nl.igorski.lib.audio.nativeaudio;

public class FormantFilter extends BaseProcessor {
  private long swigCPtr;

  protected FormantFilter(long cPtr, boolean cMemoryOwn) {
    super(NativeAudioEngineJNI.FormantFilter_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(FormantFilter obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        NativeAudioEngineJNI.delete_FormantFilter(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public FormantFilter(double aVowel) {
    this(NativeAudioEngineJNI.new_FormantFilter(aVowel), true);
  }

  public void setVowel(double aVowel) {
    NativeAudioEngineJNI.FormantFilter_setVowel(swigCPtr, this, aVowel);
  }

  public double getVowel() {
    return NativeAudioEngineJNI.FormantFilter_getVowel(swigCPtr, this);
  }

  public void process(SWIGTYPE_p_AudioBuffer audioBuffer, boolean isMonoSource) {
    NativeAudioEngineJNI.FormantFilter_process(swigCPtr, this, SWIGTYPE_p_AudioBuffer.getCPtr(audioBuffer), isMonoSource);
  }

  public boolean isCacheable() {
    return NativeAudioEngineJNI.FormantFilter_isCacheable(swigCPtr, this);
  }

  public final static int VOWEL_A = NativeAudioEngineJNI.FormantFilter_VOWEL_A_get();
  public final static int VOWEL_E = NativeAudioEngineJNI.FormantFilter_VOWEL_E_get();
  public final static int VOWEL_I = NativeAudioEngineJNI.FormantFilter_VOWEL_I_get();
  public final static int VOWEL_O = NativeAudioEngineJNI.FormantFilter_VOWEL_O_get();
  public final static int VOWEL_U = NativeAudioEngineJNI.FormantFilter_VOWEL_U_get();
}