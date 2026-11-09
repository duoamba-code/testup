package com.magicloader.app.renderer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RendererFeatures.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/magicloader/app/renderer/RendererFeature;", "", "name", "", "state", "Lcom/magicloader/app/renderer/FeatureState;", "group", "Lcom/magicloader/app/renderer/FeatureGroup;", "detail", "<init>", "(Ljava/lang/String;Lcom/magicloader/app/renderer/FeatureState;Lcom/magicloader/app/renderer/FeatureGroup;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getState", "()Lcom/magicloader/app/renderer/FeatureState;", "getGroup", "()Lcom/magicloader/app/renderer/FeatureGroup;", "getDetail", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RendererFeature {
    private final String detail;
    private final FeatureGroup group;
    private final String name;
    private final FeatureState state;

    public static /* synthetic */ RendererFeature copy$default(RendererFeature rendererFeature, String str, FeatureState featureState, FeatureGroup featureGroup, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rendererFeature.name;
        }
        if ((i & 2) != 0) {
            featureState = rendererFeature.state;
        }
        if ((i & 4) != 0) {
            featureGroup = rendererFeature.group;
        }
        if ((i & 8) != 0) {
            str2 = rendererFeature.detail;
        }
        return rendererFeature.copy(str, featureState, featureGroup, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FeatureState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FeatureGroup getGroup() {
        return this.group;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDetail() {
        return this.detail;
    }

    public final RendererFeature copy(String name, FeatureState state, FeatureGroup group, String detail) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(detail, "detail");
        return new RendererFeature(name, state, group, detail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RendererFeature)) {
            return false;
        }
        RendererFeature rendererFeature = (RendererFeature) other;
        return Intrinsics.areEqual(this.name, rendererFeature.name) && this.state == rendererFeature.state && this.group == rendererFeature.group && Intrinsics.areEqual(this.detail, rendererFeature.detail);
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.state.hashCode()) * 31) + this.group.hashCode()) * 31) + this.detail.hashCode();
    }

    public String toString() {
        return "RendererFeature(name=" + this.name + ", state=" + this.state + ", group=" + this.group + ", detail=" + this.detail + ")";
    }

    public RendererFeature(String name, FeatureState state, FeatureGroup group, String detail) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.name = name;
        this.state = state;
        this.group = group;
        this.detail = detail;
    }

    public final String getName() {
        return this.name;
    }

    public final FeatureState getState() {
        return this.state;
    }

    public final FeatureGroup getGroup() {
        return this.group;
    }

    public final String getDetail() {
        return this.detail;
    }
}
