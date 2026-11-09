package com.magicloader.app.host.runtime;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: ElfNeeded.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018J%\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00152\u0006\u0010\u001c\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0014\u0010#\u001a\u00020\u0016*\u00020 2\u0006\u0010!\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/magicloader/app/host/runtime/ElfNeeded;", "", "<init>", "()V", "HEADER_BYTES", "", "PHDR_BYTES", "DYN_BYTES", "CLASS_64", "", "LITTLE_ENDIAN", "PT_LOAD", "PT_DYNAMIC", "DT_NULL", "", "DT_NEEDED", "DT_STRTAB", "NAME_LIMIT", "MAGIC", "", "read", "", "", "file", "Ljava/io/File;", "fileOffset", "segments", "Lcom/magicloader/app/host/runtime/ElfNeeded$Segment;", "vaddr", "(Ljava/util/List;J)Ljava/lang/Long;", "bytes", "Ljava/nio/ByteBuffer;", "Ljava/io/RandomAccessFile;", "offset", "count", "cString", "Segment", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ElfNeeded {
    private static final byte CLASS_64 = 2;
    private static final long DT_NEEDED = 1;
    private static final long DT_NULL = 0;
    private static final long DT_STRTAB = 5;
    private static final int DYN_BYTES = 16;
    private static final int HEADER_BYTES = 64;
    private static final byte LITTLE_ENDIAN = 1;
    private static final int NAME_LIMIT = 256;
    private static final int PHDR_BYTES = 56;
    private static final int PT_DYNAMIC = 2;
    private static final int PT_LOAD = 1;
    public static final ElfNeeded INSTANCE = new ElfNeeded();
    private static final byte[] MAGIC = {ByteCompanionObject.MAX_VALUE, 69, 76, 70};

    private ElfNeeded() {
    }

    /* JADX INFO: compiled from: ElfNeeded.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/magicloader/app/host/runtime/ElfNeeded$Segment;", "", "type", "", "offset", "", "vaddr", "size", "<init>", "(IJJJ)V", "getType", "()I", "getOffset", "()J", "getVaddr", "getSize", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Segment {
        private final long offset;
        private final long size;
        private final int type;
        private final long vaddr;

        public Segment(int i, long j, long j2, long j3) {
            this.type = i;
            this.offset = j;
            this.vaddr = j2;
            this.size = j3;
        }

        public final long getOffset() {
            return this.offset;
        }

        public final long getSize() {
            return this.size;
        }

        public final int getType() {
            return this.type;
        }

        public final long getVaddr() {
            return this.vaddr;
        }
    }

    public final List<String> read(File file) {
        Throwable th;
        Object next;
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(file, "file");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            RandomAccessFile randomAccessFile2 = randomAccessFile;
            ByteBuffer byteBufferBytes = INSTANCE.bytes(randomAccessFile2, 0L, 64);
            Iterable indices = ArraysKt.getIndices(MAGIC);
            if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                Iterator it = indices.iterator();
                while (it.hasNext()) {
                    int iNextInt = ((IntIterator) it).nextInt();
                    if (byteBufferBytes.get(iNextInt) != MAGIC[iNextInt]) {
                        break;
                    }
                }
            }
            if (byteBufferBytes.get(4) == 2 && byteBufferBytes.get(5) == 1) {
                long j = byteBufferBytes.getLong(32);
                short s = byteBufferBytes.getShort(54);
                IntRange intRangeUntil = RangesKt.until(0, (int) byteBufferBytes.getShort(56));
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
                Iterator<Integer> it2 = intRangeUntil.iterator();
                while (it2.hasNext()) {
                    try {
                        RandomAccessFile randomAccessFile3 = randomAccessFile;
                        try {
                            ByteBuffer byteBufferBytes2 = INSTANCE.bytes(randomAccessFile2, (((long) ((IntIterator) it2).nextInt()) * ((long) s)) + j, 56);
                            arrayList.add(new Segment(byteBufferBytes2.getInt(0), byteBufferBytes2.getLong(8), byteBufferBytes2.getLong(16), byteBufferBytes2.getLong(32)));
                            randomAccessFile = randomAccessFile3;
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile = randomAccessFile3;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                CloseableKt.closeFinally(randomAccessFile, th);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        throw th;
                    }
                }
                RandomAccessFile randomAccessFile4 = randomAccessFile;
                try {
                    ArrayList arrayList2 = arrayList;
                    Iterator it3 = arrayList2.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it3.next();
                        if (((Segment) next).getType() == 2) {
                            break;
                        }
                    }
                    Segment segment = (Segment) next;
                    if (segment == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    } else {
                        ByteBuffer byteBufferBytes3 = INSTANCE.bytes(randomAccessFile2, segment.getOffset(), (int) segment.getSize());
                        ArrayList arrayList3 = new ArrayList();
                        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, byteBufferBytes3.limit() - 15), 16);
                        int first = intProgressionStep.getFirst();
                        int last = intProgressionStep.getLast();
                        int step = intProgressionStep.getStep();
                        long j2 = -1;
                        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                            while (true) {
                                long j3 = byteBufferBytes3.getLong(first);
                                if (j3 != 0) {
                                    if (j3 == 1) {
                                        arrayList3.add(Long.valueOf(byteBufferBytes3.getLong(first + 8)));
                                    }
                                    if (j3 == 5) {
                                        j2 = byteBufferBytes3.getLong(first + 8);
                                    }
                                    if (first == last) {
                                        break;
                                    }
                                    first += step;
                                } else {
                                    break;
                                }
                            }
                        }
                        Long lFileOffset = INSTANCE.fileOffset(arrayList2, j2);
                        if (lFileOffset == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        } else {
                            long jLongValue = lFileOffset.longValue();
                            ArrayList arrayList4 = arrayList3;
                            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                            Iterator it4 = arrayList4.iterator();
                            while (it4.hasNext()) {
                                arrayList5.add(INSTANCE.cString(randomAccessFile2, ((Number) it4.next()).longValue() + jLongValue));
                            }
                            arrayListEmptyList = arrayList5;
                        }
                    }
                    CloseableKt.closeFinally(randomAccessFile4, null);
                    return arrayListEmptyList;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile4;
                    th = th;
                    throw th;
                }
            }
            throw new IOException(file.getName() + " is not a 64-bit little-endian ELF");
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private final Long fileOffset(List<Segment> segments, long vaddr) {
        Object next;
        Iterator<T> it = segments.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Segment segment = (Segment) next;
            if (segment.getType() == 1 && vaddr >= segment.getVaddr() && vaddr < segment.getVaddr() + segment.getSize()) {
                break;
            }
        }
        Segment segment2 = (Segment) next;
        if (segment2 != null) {
            return Long.valueOf((vaddr - segment2.getVaddr()) + segment2.getOffset());
        }
        return null;
    }

    private final ByteBuffer bytes(RandomAccessFile randomAccessFile, long j, int i) throws IOException {
        byte[] bArr = new byte[i];
        randomAccessFile.seek(j);
        randomAccessFile.readFully(bArr);
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "order(...)");
        return byteBufferOrder;
    }

    private final String cString(RandomAccessFile randomAccessFile, long j) throws IOException {
        Integer next;
        byte[] bArr = new byte[256];
        randomAccessFile.seek(j);
        int i = randomAccessFile.read(bArr);
        Iterator<Integer> it = RangesKt.until(0, Math.max(i, 0)).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (bArr[next.intValue()] == 0) {
                break;
            }
        }
        Integer num = next;
        return new String(bArr, 0, num != null ? num.intValue() : Math.max(i, 0), Charsets.UTF_8);
    }
}
