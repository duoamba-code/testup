package com.magicloader.app.host;

import android.content.Context;
import java.io.File;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;
import org.spongycastle.i18n.TextBundle;

/* JADX INFO: compiled from: GameSettings.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J%\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/magicloader/app/host/GameSettings;", "", "<init>", "()V", "PACK_ID", "", "MODULE_ID", "FRAME_PACING_SET", "MANIFEST", "GENERAL_SECTION", "apply", "", "context", "Landroid/content/Context;", "setOptions", "file", "Ljava/io/File;", "firstTime", "", "setOption", TextBundle.TEXT_ENTRY, "key", "value", "setOption$app_release", "addToGlobalPacks", "writeWhole", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameSettings {
    private static final String FRAME_PACING_SET = "frame_pacing_set";
    private static final String MODULE_ID = "c2d84e16-9a37-4f5b-8b60-1e7f3a9d6c42";
    private static final String PACK_ID = "6f1a9c7e-3b52-4d08-9e41-7c2d5a8b1f30";
    public static final GameSettings INSTANCE = new GameSettings();
    private static final String MANIFEST = "{\n  \"format_version\": 2,\n  \"header\": {\n    \"name\": \"MagicLoader\",\n    \"description\": \"Keeps Anti-Aliasing at 1\",\n    \"uuid\": \"6f1a9c7e-3b52-4d08-9e41-7c2d5a8b1f30\",\n    \"version\": [1, 0, 0],\n    \"min_engine_version\": [1, 21, 0]\n  },\n  \"modules\": [{\"type\": \"resources\", \"uuid\": \"c2d84e16-9a37-4f5b-8b60-1e7f3a9d6c42\", \"version\": [1, 0, 0]}]\n}";
    private static final String GENERAL_SECTION = "{\n  \"namespace\": \"general_section\",\n  \"msaa_slider\": {\"$enabled\": false}\n}";

    private GameSettings() {
    }

    public final void apply(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            GameSettings gameSettings = this;
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return;
            }
            File file = new File(externalFilesDir, "games/com.mojang");
            File file2 = new File(context.getFilesDir(), FRAME_PACING_SET);
            boolean zExists = file2.exists();
            File file3 = new File(file, "resource_packs/MagicLoader");
            writeWhole(new File(file3, "manifest.json"), MANIFEST);
            writeWhole(new File(file3, "ui/settings_sections/general_section.json"), GENERAL_SECTION);
            File file4 = new File(file, "minecraftpe");
            setOptions(new File(file4, "options.txt"), !zExists);
            addToGlobalPacks(new File(file4, "global_resource_packs.json"));
            if (!zExists) {
                file2.createNewFile();
            }
            Result.m325constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m325constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final void setOptions(File file, boolean firstTime) {
        String text$default = file.exists() ? FilesKt.readText$default(file, null, 1, null) : "";
        String option$app_release = setOption$app_release(text$default, "gfx_msaa", "1");
        if (firstTime) {
            option$app_release = setOption$app_release(option$app_release, "frame_pacing_enabled", "0");
        }
        if (Intrinsics.areEqual(option$app_release, text$default)) {
            return;
        }
        writeWhole(file, option$app_release);
    }

    public final String setOption$app_release(String text, final String key, final String value) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Regex regex = new Regex("(^|\\n)" + Regex.INSTANCE.escape(key) + ":[^\\r\\n]*");
        String str = text;
        if (regex.containsMatchIn(str)) {
            return regex.replace(str, new Function1() { // from class: com.magicloader.app.host.GameSettings$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameSettings.setOption$lambda$1(key, value, (MatchResult) obj);
                }
            });
        }
        if (str.length() != 0 && !StringsKt.endsWith$default(text, "\n", false, 2, (Object) null)) {
            text = text + "\n";
        }
        return text + key + ":" + value + "\n";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence setOption$lambda$1(String str, String str2, MatchResult match) {
        Intrinsics.checkNotNullParameter(match, "match");
        return ((Object) match.getGroupValues().get(1)) + str + ":" + str2;
    }

    private final void addToGlobalPacks(File file) {
        Object objM325constructorimpl;
        String text$default = file.exists() ? FilesKt.readText$default(file, null, 1, null) : "";
        if (StringsKt.contains$default((CharSequence) text$default, (CharSequence) PACK_ID, false, 2, (Object) null)) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            GameSettings gameSettings = this;
            objM325constructorimpl = Result.m325constructorimpl(new JSONArray(text$default));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM325constructorimpl = Result.m325constructorimpl(ResultKt.createFailure(th));
        }
        JSONArray jSONArray = new JSONArray();
        if (Result.m331isFailureimpl(objM325constructorimpl)) {
            objM325constructorimpl = jSONArray;
        }
        JSONArray jSONArray2 = (JSONArray) objM325constructorimpl;
        jSONArray2.put(new JSONObject().put("pack_id", PACK_ID).put(ClientCookie.VERSION_ATTR, new JSONArray((Collection) CollectionsKt.listOf((Object[]) new Integer[]{1, 0, 0}))));
        String string = jSONArray2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        writeWhole(file, string);
    }

    private final void writeWhole(File file, String text) {
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        File file2 = new File(file.getParentFile(), file.getName() + ".magic");
        FilesKt.writeText$default(file2, text, null, 2, null);
        if (file2.renameTo(file)) {
            return;
        }
        FilesKt.writeText$default(file, text, null, 2, null);
        file2.delete();
    }
}
