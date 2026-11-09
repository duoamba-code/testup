package com.magicloader.app.host.runtime;

import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.magicloader.app.host.CompatMode;
import com.magicloader.app.host.InstallSnapshot;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GameLibraries.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u001cJ \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0013J0\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010!\u001a\u00020\u00052\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050$0#H\u0002J6\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050$0#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006("}, d2 = {"Lcom/magicloader/app/host/runtime/GameLibraries;", "", "<init>", "()V", "MAIN", "", "TAG", "JAVA_LAYER_ONLY", "", "SHIMMED", "value", "", "loaded", "getLoaded", "()Z", "variantFor", "Ljava/io/File;", "name", "mode", "Lcom/magicloader/app/host/CompatMode;", "shimDir", "load", "", "context", "Landroid/content/Context;", "install", "Lcom/magicloader/app/host/InstallSnapshot;", NotificationCompat.CATEGORY_PROGRESS, "Lkotlin/Function1;", "plan", "Lcom/magicloader/app/host/runtime/GameLibraries$Plan;", "directory", "closure", "root", "needs", "", "", "order", "chosen", "Plan", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameLibraries {
    public static final String MAIN = "libminecraftpe.so";
    private static final String TAG = "MagicHost";
    private static volatile boolean loaded;
    public static final GameLibraries INSTANCE = new GameLibraries();
    private static final Set<String> JAVA_LAYER_ONLY = SetsKt.setOf("libconscrypt_jni.so");
    private static final Set<String> SHIMMED = SetsKt.setOf((Object[]) new String[]{"libmaesdk.so", "libPlayFabMultiplayer.so"});

    private GameLibraries() {
    }

    /* JADX INFO: compiled from: GameLibraries.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/magicloader/app/host/runtime/GameLibraries$Plan;", "", "order", "", "Ljava/io/File;", "skipped", "", "", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getOrder", "()Ljava/util/List;", "getSkipped", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Plan {
        private final List<File> order;
        private final Map<String, String> skipped;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Plan copy$default(Plan plan, List list, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                list = plan.order;
            }
            if ((i & 2) != 0) {
                map = plan.skipped;
            }
            return plan.copy(list, map);
        }

        public final List<File> component1() {
            return this.order;
        }

        public final Map<String, String> component2() {
            return this.skipped;
        }

        public final Plan copy(List<? extends File> order, Map<String, String> skipped) {
            Intrinsics.checkNotNullParameter(order, "order");
            Intrinsics.checkNotNullParameter(skipped, "skipped");
            return new Plan(order, skipped);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Plan)) {
                return false;
            }
            Plan plan = (Plan) other;
            return Intrinsics.areEqual(this.order, plan.order) && Intrinsics.areEqual(this.skipped, plan.skipped);
        }

        public int hashCode() {
            return (this.order.hashCode() * 31) + this.skipped.hashCode();
        }

        public String toString() {
            return "Plan(order=" + this.order + ", skipped=" + this.skipped + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Plan(List<? extends File> order, Map<String, String> skipped) {
            Intrinsics.checkNotNullParameter(order, "order");
            Intrinsics.checkNotNullParameter(skipped, "skipped");
            this.order = order;
            this.skipped = skipped;
        }

        public final List<File> getOrder() {
            return this.order;
        }

        public final Map<String, String> getSkipped() {
            return this.skipped;
        }
    }

    public final boolean getLoaded() {
        return loaded;
    }

    private final File variantFor(String name, CompatMode mode, File shimDir) {
        if (mode == CompatMode.MBLOADER) {
            File file = new File(shimDir, StringsKt.removeSuffix(name, (CharSequence) LibraryStage.SO_SUFFIX) + "_mb.so");
            if (file.isFile()) {
                return file;
            }
        }
        return new File(shimDir, name);
    }

    public final synchronized void load(Context context, InstallSnapshot install, Function1<? super String, Unit> progress) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(install, "install");
        Intrinsics.checkNotNullParameter(progress, "progress");
        if (loaded) {
            return;
        }
        File file = new File(context.getApplicationInfo().nativeLibraryDir);
        CompatMode compatModeCurrent = CompatMode.INSTANCE.current(context);
        Log.i("MagicHost", "compat mode: " + compatModeCurrent.getId());
        Plan plan = plan(new LibraryStage(context, install).directory(progress), file, compatModeCurrent);
        for (Map.Entry<String, String> entry : plan.getSkipped().entrySet()) {
            Log.i("MagicHost", "skipped " + entry.getKey() + ": " + entry.getValue());
        }
        for (File file2 : plan.getOrder()) {
            progress.invoke("Loading " + file2.getName());
            long jNanoTime = System.nanoTime();
            System.load(file2.getAbsolutePath());
            Log.i("MagicHost", "loaded " + file2.getName() + " in " + ((System.nanoTime() - jNanoTime) / ((long) 1000000)) + " ms");
        }
        loaded = true;
    }

    public static /* synthetic */ Plan plan$default(GameLibraries gameLibraries, File file, File file2, CompatMode compatMode, int i, Object obj) {
        if ((i & 4) != 0) {
            compatMode = CompatMode.MAGICLOADER;
        }
        return gameLibraries.plan(file, file2, compatMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean plan$lambda$1(File file) {
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.endsWith$default(name, LibraryStage.SO_SUFFIX, false, 2, (Object) null);
    }

    public final Plan plan(File directory, File shimDir, CompatMode mode) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(shimDir, "shimDir");
        Intrinsics.checkNotNullParameter(mode, "mode");
        File[] fileArrListFiles = directory.listFiles(new FileFilter() { // from class: com.magicloader.app.host.runtime.GameLibraries$$ExternalSyntheticLambda0
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return GameLibraries.plan$lambda$1(file);
            }
        });
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(fileArrListFiles.length), 16));
        for (File file : fileArrListFiles) {
            linkedHashMap.put(file.getName(), file);
        }
        if (!linkedHashMap.containsKey(MAIN)) {
            throw new IllegalArgumentException(("libminecraftpe.so is missing from " + directory.getPath()).toString());
        }
        Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
        for (String str : SHIMMED) {
            if (linkedHashMap.containsKey(str)) {
                File fileVariantFor = variantFor(str, mode, shimDir);
                if (!fileVariantFor.isFile()) {
                    throw new IllegalArgumentException((str + " replacement is missing from " + shimDir.getPath()).toString());
                }
                mutableMap.put(str, fileVariantFor);
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(mutableMap.size()));
        for (Map.Entry entry : mutableMap.entrySet()) {
            Object key = entry.getKey();
            File file2 = (File) entry.getValue();
            ElfNeeded elfNeeded = ElfNeeded.INSTANCE;
            Intrinsics.checkNotNull(file2);
            List<String> list = elfNeeded.read(file2);
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (mutableMap.containsKey((String) obj)) {
                    arrayList.add(obj);
                }
            }
            linkedHashMap2.put(key, arrayList);
        }
        Set<String> mutableSet = CollectionsKt.toMutableSet(closure(MAIN, linkedHashMap2));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (String str2 : CollectionsKt.sorted(mutableMap.keySet())) {
            if (!mutableSet.contains(str2)) {
                Intrinsics.checkNotNull(str2);
                Set<String> setClosure = closure(str2, linkedHashMap2);
                if (JAVA_LAYER_ONLY.contains(str2)) {
                    linkedHashMap3.put(str2, "belongs to a Java layer MagicLoader does not run");
                } else {
                    CollectionsKt.addAll(mutableSet, setClosure);
                }
            }
        }
        List<String> listOrder = order(mutableSet, linkedHashMap2);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOrder, 10));
        Iterator<T> it = listOrder.iterator();
        while (it.hasNext()) {
            arrayList2.add((File) MapsKt.getValue(mutableMap, (String) it.next()));
        }
        return new Plan(arrayList2, linkedHashMap3);
    }

    private final Set<String> closure(String root, Map<String, ? extends List<String>> needs) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayDeque arrayDeque = new ArrayDeque(CollectionsKt.listOf(root));
        while (true) {
            ArrayDeque arrayDeque2 = arrayDeque;
            if (!arrayDeque2.isEmpty()) {
                String str = (String) arrayDeque.removeFirst();
                if (linkedHashSet.add(str)) {
                    List<String> listEmptyList = needs.get(str);
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    CollectionsKt.addAll(arrayDeque2, listEmptyList);
                }
            } else {
                return linkedHashSet;
            }
        }
    }

    private final List<String> order(Set<String> chosen, Map<String, ? extends List<String>> needs) {
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = CollectionsKt.sorted(SetsKt.minus(chosen, MAIN)).iterator();
        while (it.hasNext()) {
            order$visit(linkedHashSet, needs, arrayList, chosen, (String) it.next());
        }
        order$visit(linkedHashSet, needs, arrayList, chosen, MAIN);
        return arrayList;
    }

    private static final void order$visit(Set<String> set, Map<String, ? extends List<String>> map, List<String> list, Set<String> set2, String str) {
        if (set.add(str)) {
            List<String> listEmptyList = map.get(str);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : listEmptyList) {
                if (set2.contains((String) obj)) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                order$visit(set, map, list, set2, (String) it.next());
            }
            list.add(str);
        }
    }
}
