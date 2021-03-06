/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.opengl;

import org.lwjgl.system.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.JNI.*;

/**
 * Native bindings to the <a href="http://www.opengl.org/registry/specs/ARB/texture_storage_multisample.txt">ARB_texture_storage_multisample</a> extension.
 * 
 * <p>The {@link ARBTextureStorage ARB_texture_storage} extension and OpenGL 4.2 introduced the concept of immutable texture objects. With these objects, once their data store
 * has been sized and allocated, it could not be resized for the lifetime of the objects (although its content could be updated). OpenGL implementations
 * may be able to take advantage of the knowledge that the underlying data store of certain objects cannot be deleted or otherwise reallocated without
 * destruction of the whole object (normally, a much heavier weight and less frequent operation). Immutable storage for all types of textures besides
 * multisample and buffer textures was introduced by ARB_texture_storage. For completeness, this extension introduces immutable storage for multisampled
 * textures.</p>
 * 
 * <p>Requires {@link GL42 OpenGL 4.2} or {@link ARBTextureStorage ARB_texture_storage}. Promoted to core in {@link GL43 OpenGL 4.3}.</p>
 */
public class ARBTextureStorageMultisample {

	/** Function address. */
	@JavadocExclude
	public final long
		TexStorage2DMultisample,
		TexStorage3DMultisample,
		TextureStorage2DMultisampleEXT,
		TextureStorage3DMultisampleEXT;

	@JavadocExclude
	protected ARBTextureStorageMultisample() {
		throw new UnsupportedOperationException();
	}

	@JavadocExclude
	public ARBTextureStorageMultisample(FunctionProvider provider) {
		TexStorage2DMultisample = provider.getFunctionAddress("glTexStorage2DMultisample");
		TexStorage3DMultisample = provider.getFunctionAddress("glTexStorage3DMultisample");
		TextureStorage2DMultisampleEXT = provider.getFunctionAddress("glTextureStorage2DMultisampleEXT");
		TextureStorage3DMultisampleEXT = provider.getFunctionAddress("glTextureStorage3DMultisampleEXT");
	}

	// --- [ Function Addresses ] ---

	/** Returns the {@link ARBTextureStorageMultisample} instance of the current context. */
	public static ARBTextureStorageMultisample getInstance() {
		return getInstance(GL.getCapabilities());
	}

	/** Returns the {@link ARBTextureStorageMultisample} instance of the specified {@link GLCapabilities}. */
	public static ARBTextureStorageMultisample getInstance(GLCapabilities caps) {
		return checkFunctionality(caps.__ARBTextureStorageMultisample);
	}

	static ARBTextureStorageMultisample create(java.util.Set<String> ext, FunctionProvider provider) {
		if ( !ext.contains("GL_ARB_texture_storage_multisample") ) return null;

		ARBTextureStorageMultisample funcs = new ARBTextureStorageMultisample(provider);

		boolean supported = checkFunctions(
			funcs.TexStorage2DMultisample, funcs.TexStorage3DMultisample, 
			ext.contains("GL_EXT_direct_state_access") ? funcs.TextureStorage2DMultisampleEXT : -1L, 
			ext.contains("GL_EXT_direct_state_access") ? funcs.TextureStorage3DMultisampleEXT : -1L
		);

		return GL.checkExtension("GL_ARB_texture_storage_multisample", funcs, supported);
	}

	// --- [ glTexStorage2DMultisample ] ---

	/**
	 * Specifies storage for a two-dimensional multisample texture.
	 *
	 * @param target               the target of the operation. One of:<br>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE TEXTURE_2D_MULTISAMPLE}, {@link GL32#GL_PROXY_TEXTURE_2D_MULTISAMPLE PROXY_TEXTURE_2D_MULTISAMPLE}
	 * @param samples              the number of samples in the texture
	 * @param internalformat       the sized internal format to be used to store texture image data
	 * @param width                the width of the texture, in texels
	 * @param height               the height of the texture, in texels
	 * @param fixedsamplelocations whether the image will use identical sample locations and the same number of samples for all texels in the image, and the sample locations will not
	 *                             depend on the internal format or size of the image
	 */
	public static void glTexStorage2DMultisample(int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) {
		long __functionAddress = getInstance().TexStorage2DMultisample;
		callIIIIIZV(__functionAddress, target, samples, internalformat, width, height, fixedsamplelocations);
	}

	// --- [ glTexStorage3DMultisample ] ---

	/**
	 * Specifies storage for a two-dimensional multisample array texture.
	 *
	 * @param target               the target of the operation. One of:<br>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE_ARRAY TEXTURE_2D_MULTISAMPLE_ARRAY}, {@link GL32#GL_PROXY_TEXTURE_2D_MULTISAMPLE PROXY_TEXTURE_2D_MULTISAMPLE}
	 * @param samples              the number of samples in the texture
	 * @param internalformat       the sized internal format to be used to store texture image data
	 * @param width                the width of the texture, in texels
	 * @param height               the height of the texture, in texels
	 * @param depth                the depth of the texture, in texels
	 * @param fixedsamplelocations whether the image will use identical sample locations and the same number of samples for all texels in the image, and the sample locations will not
	 *                             depend on the internal format or size of the image
	 */
	public static void glTexStorage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations) {
		long __functionAddress = getInstance().TexStorage3DMultisample;
		callIIIIIIZV(__functionAddress, target, samples, internalformat, width, height, depth, fixedsamplelocations);
	}

	// --- [ glTextureStorage2DMultisampleEXT ] ---

	/**
	 * DSA version of {@link #glTexStorage2DMultisample TexStorage2DMultisample}.
	 *
	 * @param texture              the texture object
	 * @param target               the target of the operation. One of:<br>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE TEXTURE_2D_MULTISAMPLE}, {@link GL32#GL_PROXY_TEXTURE_2D_MULTISAMPLE PROXY_TEXTURE_2D_MULTISAMPLE}
	 * @param samples              the number of samples in the texture
	 * @param internalformat       the sized internal format to be used to store texture image data
	 * @param width                the width of the texture, in texels
	 * @param height               the height of the texture, in texels
	 * @param fixedsamplelocations whether the image will use identical sample locations and the same number of samples for all texels in the image, and the sample locations will not
	 *                             depend on the internal format or size of the image
	 */
	public static void glTextureStorage2DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) {
		long __functionAddress = getInstance().TextureStorage2DMultisampleEXT;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIIIIIIZV(__functionAddress, texture, target, samples, internalformat, width, height, fixedsamplelocations);
	}

	// --- [ glTextureStorage3DMultisampleEXT ] ---

	/**
	 * DSA version of {@link #glTexStorage3DMultisample TexStorage3DMultisample}.
	 *
	 * @param texture              the texture object
	 * @param target               the target of the operation. One of:<br>{@link GL32#GL_TEXTURE_2D_MULTISAMPLE_ARRAY TEXTURE_2D_MULTISAMPLE_ARRAY}, {@link GL32#GL_PROXY_TEXTURE_2D_MULTISAMPLE PROXY_TEXTURE_2D_MULTISAMPLE}
	 * @param samples              the number of samples in the texture
	 * @param internalformat       the sized internal format to be used to store texture image data
	 * @param width                the width of the texture, in texels
	 * @param height               the height of the texture, in texels
	 * @param depth                the depth of the texture, in texels
	 * @param fixedsamplelocations whether the image will use identical sample locations and the same number of samples for all texels in the image, and the sample locations will not
	 *                             depend on the internal format or size of the image
	 */
	public static void glTextureStorage3DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, int depth, boolean fixedsamplelocations) {
		long __functionAddress = getInstance().TextureStorage3DMultisampleEXT;
		if ( CHECKS )
			checkFunctionAddress(__functionAddress);
		callIIIIIIIZV(__functionAddress, texture, target, samples, internalformat, width, height, depth, fixedsamplelocations);
	}

}