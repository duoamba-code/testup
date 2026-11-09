package com.magicloader.app.renderer;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: RendererFeatures.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/magicloader/app/renderer/FeatureState;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "Live", "Lab", "Blocked", "Unsupported", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FeatureState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FeatureState[] $VALUES;
    private final String label;
    public static final FeatureState Live = new FeatureState("Live", 0, "in game");
    public static final FeatureState Lab = new FeatureState("Lab", 1, "lab");
    public static final FeatureState Blocked = new FeatureState("Blocked", 2, "blocked");
    public static final FeatureState Unsupported = new FeatureState("Unsupported", 3, "no hw");

    private static final /* synthetic */ FeatureState[] $values() {
        return new FeatureState[]{Live, Lab, Blocked, Unsupported};
    }

    public static EnumEntries<FeatureState> getEntries() {
        return $ENTRIES;
    }

    public static FeatureState valueOf(String str) {
        return (FeatureState) Enum.valueOf(FeatureState.class, str);
    }

    public static FeatureState[] values() {
        return (FeatureState[]) $VALUES.clone();
    }

    private FeatureState(String str, int i, String str2) {
        this.label = str2;
    }

    public final String getLabel() {
        return this.label;
    }

    static {
        FeatureState[] featureStateArr$values = $values();
        $VALUES = featureStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(featureStateArr$values);
    }
}
