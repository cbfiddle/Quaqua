/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class ch_randelshofer_quaqua_datatransfer_NSPasteboardTransferable */

#ifndef _Included_ch_randelshofer_quaqua_datatransfer_NSPasteboardTransferable
#define _Included_ch_randelshofer_quaqua_datatransfer_NSPasteboardTransferable
#ifdef __cplusplus
extern "C" {
#endif
/* Inaccessible static: isNativeCodeAvailable */
/* Inaccessible static: EXPECTED_NATIVE_CODE_VERSION */
/*
 * Class:     ch_randelshofer_quaqua_datatransfer_NSPasteboardTransferable
 * Method:    getTypes
 * Signature: ()[Ljava/lang/String;
 */
JNIEXPORT jobjectArray JNICALL Java_ch_randelshofer_quaqua_datatransfer_NSPasteboardTransferable_getTypes
  (JNIEnv *, jclass);

/*
 * Class:     ch_randelshofer_quaqua_datatransfer_NSPasteboardTransferable
 * Method:    getDataForType
 * Signature: (Ljava/lang/String;)[B
 */
JNIEXPORT jbyteArray JNICALL Java_ch_randelshofer_quaqua_datatransfer_NSPasteboardTransferable_getDataForType
  (JNIEnv *, jclass, jstring);

/*
 * Class:     ch_randelshofer_quaqua_datatransfer_NSPasteboardTransferable
 * Method:    getNativeCodeVersion
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_ch_randelshofer_quaqua_datatransfer_NSPasteboardTransferable_getNativeCodeVersion
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
