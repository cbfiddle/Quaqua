/*
 * @(#)ch_randelshofer_quaqua_osx_OSXApplication.c
 *
 * Copyright (c) 2007 Werner Randelshofer
 * Staldenmattweg 2, Immensee, CH-6405, Switzerland.
 * All rights reserved.
 *
 * The copyright of this software is owned by Werner Randelshofer. 
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * Werner Randelshofer. For details see accompanying license terms. 
 */

/**
 * Native code for class ch.randelshofer.quaqua.osx.OSXApplication.
 *
 * @version $Id$
 */

#include <stdio.h>
#include <jni.h>
#include "ch_randelshofer_quaqua_osx_OSXApplication.h"
#import <Cocoa/Cocoa.h>
/*
 * Class:     ch_randelshofer_quaqua_osx_OSXApplication
 * Method:    requestUserAttention
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL Java_ch_randelshofer_quaqua_osx_OSXApplication_nativeRequestUserAttention
  (JNIEnv * env, jclass javaClass, jboolean isCritical) 
{
    if (isCritical) {
        [NSApp requestUserAttention: NSCriticalRequest];
    } else {
        [NSApp requestUserAttention: NSInformationalRequest];
    }
}

/*
 * Class:     ch_randelshofer_quaqua_osx_OSXApplication
 * Method:    jniGetIconImage
 * Signature: (I)[B
 */
JNIEXPORT jbyteArray JNICALL Java_ch_randelshofer_quaqua_osx_OSXApplication_nativeGetIconImage
  (JNIEnv * env, jclass javaClass, jint size)
{
    jbyteArray result = NULL;

    // Allocate a memory pool
	NSAutoreleasePool* pool = [NSAutoreleasePool new];

    // Get the icon image
	NSApplication* application = [NSApplication sharedApplication];
	NSSize iconSize = { size, size };
	NSImage* image = [application applicationIconImage];
    /* Don't scale image here - apparently the algorithm only uses bilinear
       interpolation. For optimal results, we need bicubic interpolation.
	image = [image copy];
	[image setScalesWhenResized:true];
	[image setSize:iconSize];
    */
	NSData* dataNS = [image TIFFRepresentation];
    if (dataNS != NULL) {
    
        unsigned len = [dataNS length];
        void* bytes = malloc(len);
        [dataNS getBytes:bytes];

        result = (*env)->NewByteArray(env, len);
        (*env)->SetByteArrayRegion(env, result, 0, len, (jbyte*)bytes);
        free(bytes);
    }

    // Release memory pool
	[pool release];

	return result;
}

/*
 * Class:     ch_randelshofer_quaqua_osx_OSXApplication
 * Method:    getNativeCodeVersion
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_ch_randelshofer_quaqua_osx_OSXApplication_nativeGetNativeCodeVersion
  (JNIEnv *env, jclass javaClass) {
    return 2;
}