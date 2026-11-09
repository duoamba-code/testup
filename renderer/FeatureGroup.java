package com.magicloader.app.renderer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.spongycastle.i18n.MessageBundle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: RendererFeatures.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/magicloader/app/renderer/FeatureGroup;", "", MessageBundle.TITLE_ENTRY, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "InGame", "MagicRt", "Missing", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FeatureGroup {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FeatureGroup[] $VALUES;
    public static final FeatureGroup InGame = new FeatureGroup("InGame", 0, "In game");
    public static final FeatureGroup MagicRt = new FeatureGroup("MagicRt", 1, "MagicRT · shader lab");
    public static final FeatureGroup Missing = new FeatureGroup("Missing", 2, "Not available yet");
    private final String title;

    private static final /* synthetic */ FeatureGroup[] $values() {
        return new FeatureGroup[]{InGame, MagicRt, Missing};
    }

    public static EnumEntries<FeatureGroup> getEntries() {
        return $ENTRIES;
    }

    public static FeatureGroup valueOf(String str) {
        return (FeatureGroup) Enum.valueOf(FeatureGroup.class, str);
    }

    public static FeatureGroup[] values() {
        return (FeatureGroup[]) $VALUES.clone();
    }

    private FeatureGroup(String str, int i, String str2) {
        this.title = str2;
    }

    public final String getTitle() {
        return this.title;
    }

    static {
        FeatureGroup[] featureGroupArr$values = $values();
        $VALUES = featureGroupArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(featureGroupArr$values);
    }
}
