package com.magicloader.app.host.runtime;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.magicloader.app.host.GameSettings;
import com.magicloader.app.host.HostDecision;
import com.magicloader.app.host.HostDecisionKt;
import com.magicloader.app.host.HostTrust;
import com.magicloader.app.host.InstalledGameKt;
import com.magicloader.app.launch.LaunchChecksKt;
import com.magicloader.runtime.GameRuntime;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GameBoot.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\f"}, d2 = {"Lcom/magicloader/app/host/runtime/GameBoot;", "", "<init>", "()V", "prepare", "", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_PROGRESS, "Lkotlin/Function1;", "", "prepareBlocking", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameBoot {
    public static final GameBoot INSTANCE = new GameBoot();

    private GameBoot() {
    }

    @JvmStatic
    public static final void prepare(Context context, Function1<? super String, Unit> progress) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(progress, "progress");
        GameRuntime.installSecurityProvider();
        HostDecision hostDecisionDecideHost = HostDecisionKt.decideHost(InstalledGameKt.readInstalledGame(context), HostTrust.INSTANCE.current(context).getAllowsUnofficial());
        if (!(hostDecisionDecideHost instanceof HostDecision.Ready)) {
            throw new IllegalStateException(LaunchChecksKt.hostRefusal(hostDecisionDecideHost).toString());
        }
        GameSettings.INSTANCE.apply(context);
        GameRuntime.configure(context, "com.mojang.minecraftpe", true);
        HostDecision.Ready ready = (HostDecision.Ready) hostDecisionDecideHost;
        GameLibraries.INSTANCE.load(context, ready.getInstall(), progress);
        if (new File(context.getFilesDir(), "no_presenthook").exists()) {
            progress.invoke("MagicLoader renderer disabled");
        } else {
            progress.invoke("Starting MagicLoader renderer");
            HostRuntime.start(context, ready.getInstall().getApks());
        }
    }

    @JvmStatic
    public static final void prepareBlocking(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        prepare(context, new Function1() { // from class: com.magicloader.app.host.runtime.GameBoot$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameBoot.prepareBlocking$lambda$1((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepareBlocking$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
