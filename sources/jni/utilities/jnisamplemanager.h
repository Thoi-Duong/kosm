/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2013-2014 Igor Zinken - http://www.igorski.nl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
#ifndef JNISAMPLEMANAGER_H_INCLUDED
#define JNISAMPLEMANAGER_H_INCLUDED

#include "samplemanager.h"
#include "../audiobuffer.h"
#include "../javabridge.h"

// these provide hooks into the SampleManager and TablePool, accessible via JNI from Java

class JNISampleManager
{
    public:
        static AudioBuffer* getSample( jstring aIdentifier );
        static bool hasSample        ( jstring aIdentifier );
        static void setSample        ( jstring aKey, jint aBufferLength, jint aChannelAmount,
                                       jdoubleArray aBuffer, jdoubleArray aOptRightBuffer );
        static void cacheTable       ( jint tableLength, jint waveformType );
        static void cacheTable       ( jint tableLength, jint waveformType, jdoubleArray aBuffer );
};

#endif