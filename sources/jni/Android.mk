LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE      := mwengine
LOCAL_C_INCLUDES  := $(LOCAL_PATH)
LOCAL_CFLAGS      := -O3
LOCAL_CPPFLAGS    := $(LOCAL_CFLAGS)
LOCAL_SRC_FILES   := \
chunkware/SimpleEnvelope.cpp \
chunkware/SimpleGate.cpp \
chunkware/SimpleComp.cpp \
chunkware/SimpleLimit.cpp \
java_interface_wrap.cpp \
javabridge.cpp \
global.cpp \
utilities/utils.cpp \
audioengine.cpp \
opensl_io.c \
adsr.cpp \
audiobuffer.cpp \
audiochannel.cpp \
arpeggiator.cpp \
instruments/baseinstrument.cpp \
instruments/druminstrument.cpp \
instruments/synthinstrument.cpp \
drumpattern.cpp \
events/baseaudioevent.cpp \
events/basecacheableaudioevent.cpp \
events/drumevent.cpp \
events/basesynthevent.cpp \
events/synthevent.cpp \
events/sampleevent.cpp \
processors/baseprocessor.cpp \
processors/bitcrusher.cpp \
processors/compressor.cpp \
processors/dcoffsetfilter.cpp \
processors/decimator.cpp \
processors/delay.cpp \
processors/filter.cpp \
processors/finalizer.cpp \
processors/fm.cpp \
processors/formantfilter.cpp \
processors/limiter.cpp \
processors/lpfhpfilter.cpp \
processors/phaser.cpp \
processors/pitchshifter.cpp \
processors/waveshaper.cpp \
generators/wavegenerator.cpp \
utilities/bufferutility.cpp \
utilities/bulkcacher.cpp \
utilities/diskwriter.cpp \
envelopefollower.cpp \
lfo.cpp \
observer.cpp \
processingchain.cpp \
ringbuffer.cpp \
utilities/jnisamplemanager.cpp \
utilities/samplemanager.cpp \
utilities/tablepool.cpp \
sequencer.cpp \
sequencer_api.cpp \
wavetable.cpp \
utilities/wavewriter.cpp \
routeableoscillator.cpp \
kosm/audioparticleevent.cpp \

LOCAL_LDLIBS := -llog -lOpenSLES

include $(BUILD_SHARED_LIBRARY)
