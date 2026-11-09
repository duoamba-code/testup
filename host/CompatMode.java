package com.magicloader.app.host;

import android.content.Context;
import com.google.firebase.messaging.Constants;
import com.magicloader.app.SettingsActivity;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.simpleframework.xml.strategy.Name;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CompatMode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/magicloader/app/host/CompatMode;", "", Name.MARK, "", Constants.ScionAnalytics.PARAM_LABEL, "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLabel", "MAGICLOADER", "MBLOADER", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CompatMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CompatMode[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final String FILE = "compat_mode";
    public static final CompatMode MAGICLOADER = new CompatMode("MAGICLOADER", 0, "magicloader", SettingsActivity.APP_NAME);
    public static final CompatMode MBLOADER = new CompatMode("MBLOADER", 1, "mbloader", "MB Loader");
    private final String id;
    private final String label;

    private static final /* synthetic */ CompatMode[] $values() {
        return new CompatMode[]{MAGICLOADER, MBLOADER};
    }

    public static EnumEntries<CompatMode> getEntries() {
        return $ENTRIES;
    }

    public static CompatMode valueOf(String str) {
        return (CompatMode) Enum.valueOf(CompatMode.class, str);
    }

    public static CompatMode[] values() {
        return (CompatMode[]) $VALUES.clone();
    }

    private CompatMode(String str, int i, String str2, String str3) {
        this.id = str2;
        this.label = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLabel() {
        return this.label;
    }

    static {
        CompatMode[] compatModeArr$values = $values();
        $VALUES = compatModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(compatModeArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: CompatMode.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/magicloader/app/host/CompatMode$Companion;", "", "<init>", "()V", "FILE", "", "current", "Lcom/magicloader/app/host/CompatMode;", "context", "Landroid/content/Context;", "set", "", "mode", "toggle", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CompatMode current(Context context) {
            Object objM325constructorimpl;
            Intrinsics.checkNotNullParameter(context, "context");
            CompatMode compatMode = null;
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                objM325constructorimpl = Result.m325constructorimpl(StringsKt.trim((CharSequence) FilesKt.readText$default(new File(context.getFilesDir(), CompatMode.FILE), null, 1, null)).toString());
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM325constructorimpl = Result.m325constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m331isFailureimpl(objM325constructorimpl)) {
                objM325constructorimpl = null;
            }
            String str = (String) objM325constructorimpl;
            Iterator<CompatMode> it = CompatMode.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CompatMode next = it.next();
                if (Intrinsics.areEqual(next.getId(), str)) {
                    compatMode = next;
                    break;
                }
            }
            CompatMode compatMode2 = compatMode;
            return compatMode2 == null ? CompatMode.MAGICLOADER : compatMode2;
        }

        public final void set(Context context, CompatMode mode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mode, "mode");
            try {
                Result.Companion companion = Result.INSTANCE;
                Companion companion2 = this;
                FilesKt.writeText$default(new File(context.getFilesDir(), CompatMode.FILE), mode.getId(), null, 2, null);
                Result.m325constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.m325constructorimpl(ResultKt.createFailure(th));
            }
        }

        public final CompatMode toggle(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            CompatMode compatMode = current(context) == CompatMode.MAGICLOADER ? CompatMode.MBLOADER : CompatMode.MAGICLOADER;
            set(context, compatMode);
            return compatMode;
        }
    }
}
