package com.magicloader.app.host.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.magicloader.app.ui.DpKt;
import com.magicloader.app.ui.components.AppMarkKt;
import com.magicloader.app.ui.components.LabelKt;
import com.magicloader.app.ui.components.ScreenKt;
import com.magicloader.app.ui.components.StackKt;
import com.magicloader.app.ui.theme.Palette;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GameBootActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/magicloader/app/host/runtime/GameBootActivity;", "Landroid/app/Activity;", "<init>", "()V", NotificationCompat.CATEGORY_STATUS, "Landroid/widget/TextView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openGame", "showFailure", "failure", "", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameBootActivity extends Activity {

    @Deprecated
    public static final String BOOT_THREAD = "MagicBoot";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String FAILED = "Minecraft could not start without root.";

    @Deprecated
    public static final String STARTING = "Starting Minecraft…";

    @Deprecated
    public static final String TAG = "MagicHost";
    private TextView status;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenKt.applyScreenChrome(this);
        GameBootActivity gameBootActivity = this;
        TextView textViewLabel$default = LabelKt.label$default(gameBootActivity, STARTING, 15.0f, Palette.INSTANCE.getTextMuted(), false, 16, null);
        textViewLabel$default.setGravity(17);
        this.status = textViewLabel$default;
        LinearLayout linearLayoutScreenColumn = ScreenKt.screenColumn(gameBootActivity);
        linearLayoutScreenColumn.setGravity(17);
        Context context = linearLayoutScreenColumn.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int iDp = DpKt.dp(context, 76);
        Context context2 = linearLayoutScreenColumn.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        linearLayoutScreenColumn.addView(AppMarkKt.appMark(context2), new LinearLayout.LayoutParams(iDp, iDp));
        TextView textView = this.status;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
            textView = null;
        }
        Context context3 = linearLayoutScreenColumn.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        linearLayoutScreenColumn.addView(textView, StackKt.stackParams(context3, 18));
        setContentView(linearLayoutScreenColumn);
        ThreadsKt.thread$default(false, false, null, BOOT_THREAD, 0, new Function0() { // from class: com.magicloader.app.host.runtime.GameBootActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameBootActivity.onCreate$lambda$6(this.f$0);
            }
        }, 23, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$6(final GameBootActivity gameBootActivity) {
        Object objM325constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            GameBoot.prepare(gameBootActivity, new Function1() { // from class: com.magicloader.app.host.runtime.GameBootActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameBootActivity.onCreate$lambda$6$lambda$4$lambda$3(this.f$0, (String) obj);
                }
            });
            objM325constructorimpl = Result.m325constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM325constructorimpl = Result.m325constructorimpl(ResultKt.createFailure(th));
        }
        final Throwable thM328exceptionOrNullimpl = Result.m328exceptionOrNullimpl(objM325constructorimpl);
        gameBootActivity.runOnUiThread(new Runnable() { // from class: com.magicloader.app.host.runtime.GameBootActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                GameBootActivity.onCreate$lambda$6$lambda$5(thM328exceptionOrNullimpl, gameBootActivity);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$6$lambda$4$lambda$3(final GameBootActivity gameBootActivity, final String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        gameBootActivity.runOnUiThread(new Runnable() { // from class: com.magicloader.app.host.runtime.GameBootActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                GameBootActivity.onCreate$lambda$6$lambda$4$lambda$3$lambda$2(this.f$0, text);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6$lambda$4$lambda$3$lambda$2(GameBootActivity gameBootActivity, String str) {
        TextView textView = gameBootActivity.status;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
            textView = null;
        }
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6$lambda$5(Throwable th, GameBootActivity gameBootActivity) {
        if (th == null) {
            gameBootActivity.openGame();
        } else {
            gameBootActivity.showFailure(th);
        }
    }

    private final void openGame() {
        startActivity(new Intent(this, (Class<?>) HostedGameActivity.class).setData(getIntent().getData()).setAction(getIntent().getAction()));
        finish();
    }

    private final void showFailure(Throwable failure) {
        Log.e(TAG, "Rootless start failed", failure);
        TextView textView = this.status;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
            textView = null;
        }
        textView.setTextColor(Palette.INSTANCE.getDanger());
        TextView textView3 = this.status;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(NotificationCompat.CATEGORY_STATUS);
        } else {
            textView2 = textView3;
        }
        String message = failure.getMessage();
        if (message == null) {
            message = failure.getClass().getSimpleName();
        }
        textView2.setText("Minecraft could not start without root.\n" + message);
    }

    /* JADX INFO: compiled from: GameBootActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/magicloader/app/host/runtime/GameBootActivity$Companion;", "", "<init>", "()V", "TAG", "", "BOOT_THREAD", "STARTING", "FAILED", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
