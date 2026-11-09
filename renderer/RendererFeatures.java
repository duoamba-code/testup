package com.magicloader.app.renderer;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RendererFeatures.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/magicloader/app/renderer/RendererFeatures;", "", "<init>", "()V", "all", "", "Lcom/magicloader/app/renderer/RendererFeature;", "getAll", "()Ljava/util/List;", "count", "", "state", "Lcom/magicloader/app/renderer/FeatureState;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RendererFeatures {
    public static final RendererFeatures INSTANCE = new RendererFeatures();
    private static final List<RendererFeature> all = CollectionsKt.listOf((Object[]) new RendererFeature[]{new RendererFeature("Frame capture", FeatureState.Live, FeatureGroup.InGame, "Hooks Minecraft's eglSwapBuffers through a RELRO-safe GOT patch."), new RendererFeature("Tonemapping", FeatureState.Live, FeatureGroup.InGame, "AgX, ACES, Reinhard and PBR Neutral. Switch from the in-game button."), new RendererFeature("Auto HDR + exposure", FeatureState.Live, FeatureGroup.InGame, "Inverse-tonemap expansion of the 8-bit frame plus histogram auto exposure."), new RendererFeature("Bloom + color grade", FeatureState.Live, FeatureGroup.InGame, "Soft-knee bloom, saturation, contrast and vignette."), new RendererFeature("Shader packs", FeatureState.Live, FeatureGroup.InGame, "Final-image packs from the module: Cinematic, Noir, Vivid ACES."), new RendererFeature("Depth + G-buffer", FeatureState.Lab, FeatureGroup.MagicRt, "MagicRT reads albedo, normals and depth. The game hook cannot capture them yet."), new RendererFeature("Soft shadows + SSAO", FeatureState.Lab, FeatureGroup.MagicRt, "12-tap PCF sun shadows and spiral SSAO. Needs a sun shadow map."), new RendererFeature("Water + SSR", FeatureState.Lab, FeatureGroup.MagicRt, "Screen-space reflections, refraction depth, caustics and foam."), new RendererFeature("Volumetric light", FeatureState.Lab, FeatureGroup.MagicRt, "God rays marched through the shadow map, with height fog."), new RendererFeature("Camera matrices", FeatureState.Blocked, FeatureGroup.Missing, "Minecraft loads GL through eglGetProcAddress, so draw calls skip our hook."), new RendererFeature("Chunk meshes", FeatureState.Blocked, FeatureGroup.Missing, "Needed for path tracing. Same GL capture rework as depth."), new RendererFeature("Ray query", FeatureState.Unsupported, FeatureGroup.Missing, "Adreno 640 has no VK_KHR_ray_query, and this path renders with GLES.")});

    private RendererFeatures() {
    }

    public final List<RendererFeature> getAll() {
        return all;
    }

    public final int count(FeatureState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        List<RendererFeature> list = all;
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((RendererFeature) it.next()).getState() == state && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }
}
