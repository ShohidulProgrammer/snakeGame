/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.egl;

import org.lwjgl.system.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.JNI.*;

/**
 * Native bindings to the <a href="https://www.khronos.org/registry/egl/extensions/ANDROID/EGL_ANDROID_blob_cache.txt">ANDROID_blob_cache</a> extension.
 * 
 * <p>Shader compilation and optimization has been a troublesome aspect of OpenGL programming for a long time. It can consume seconds of CPU cycles during
 * application start-up. Additionally, state-based re-compiles done internally by the drivers add an unpredictable element to application performance
 * tuning, often leading to occasional pauses in otherwise smooth animations.</p>
 * 
 * <p>This extension provides a mechanism through which client API implementations may cache shader binaries after they are compiled. It may then retrieve
 * those cached shaders during subsequent executions of the same program. The management of the cache is handled by the application (or middleware),
 * allowing it to be tuned to a particular platform or environment.</p>
 * 
 * <p>While the focus of this extension is on providing a persistent cache for shader binaries, it may also be useful for caching other data. This is
 * perfectly acceptable, but the guarantees provided (or lack thereof) were designed around the shader use case.</p>
 * 
 * <p>Note that although this extension is written as if the application implements the caching functionality, on the Android OS it is implemented as part of
 * the Android EGL module. This extension is not exposed to applications on Android, but will be used automatically in every application that uses EGL if
 * it is supported by the underlying device-specific EGL implementation.</p>
 */
public class ANDROIDBlobCache {

	/** Function address. */
	@JavadocExclude
	public final long SetBlobCacheFuncsANDROID;

	@JavadocExclude
	protected ANDROIDBlobCache() {
		throw new UnsupportedOperationException();
	}

	@JavadocExclude
	public ANDROIDBlobCache(FunctionProvider provider) {
		SetBlobCacheFuncsANDROID = provider.getFunctionAddress("eglSetBlobCacheFuncsANDROID");
	}

	// --- [ Function Addresses ] ---

	/** Returns the {@link ANDROIDBlobCache} instance. */
	public static ANDROIDBlobCache getInstance() {
		return getInstance(EGL.getCapabilities());
	}

	/** Returns the {@link ANDROIDBlobCache} instance of the specified {@link EGLCapabilities}. */
	public static ANDROIDBlobCache getInstance(EGLCapabilities caps) {
		return checkFunctionality(caps.__ANDROIDBlobCache);
	}

	// --- [ eglSetBlobCacheFuncsANDROID ] ---

	public static void eglSetBlobCacheFuncsANDROID(long dpy, EGLSetBlobFuncANDROID set, EGLGetBlobFuncANDROID get) {
		long __functionAddress = getInstance().SetBlobCacheFuncsANDROID;
		if ( CHECKS )
			checkPointer(dpy);
		callPPPV(__functionAddress, dpy, set.address(), get.address());
	}

}