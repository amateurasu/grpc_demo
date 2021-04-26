package vn.elite.test.capnp;

import org.capnproto.*;

public final class Messages {
    public static class Wifi {
        public static final StructSize STRUCT_SIZE = new StructSize((short) 1, (short) 2);
        public static final Factory factory = new Factory();
        public static final StructList.Factory<Builder, Reader> listFactory = new StructList.Factory<>(factory);

        public enum Type {
            WIFI, SOS, _NOT_IN_SCHEMA,
        }

        public enum Connection {
            GSM, NBIOT, _NOT_IN_SCHEMA,
        }

        public static final class Factory extends StructFactory<Builder, Reader> {
            public Factory() {
            }

            public final Reader constructReader(
                SegmentReader segment, int data, int pointers, int dataSize, short pointerCount, int nestingLimit
            ) {
                return new Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit);
            }

            public final Builder constructBuilder(
                SegmentBuilder segment, int data, int pointers, int dataSize, short pointerCount
            ) {
                return new Builder(segment, data, pointers, dataSize, pointerCount);
            }

            public final StructSize structSize() {
                return Wifi.STRUCT_SIZE;
            }

            public final Reader asReader(Builder builder) {
                return builder.asReader();
            }
        }

        public static final class Builder extends StructBuilder {
            Builder(SegmentBuilder segment, int data, int pointers, int dataSize, short pointerCount) {
                super(segment, data, pointers, dataSize, pointerCount);
            }

            public final Reader asReader() {
                return new Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff);
            }

            public final Type getType() {
                switch (_getShortField(0)) {
                    case 0: return Type.WIFI;
                    case 1: return Type.SOS;
                    default: return Type._NOT_IN_SCHEMA;
                }
            }

            public final void setType(Type value) {
                _setShortField(0, (short) value.ordinal());
            }

            public final Connection getConnection() {
                switch (_getShortField(1)) {
                    case 0: return Connection.GSM;
                    case 1: return Connection.NBIOT;
                    default: return Connection._NOT_IN_SCHEMA;
                }
            }

            public final void setConnection(Connection value) {
                _setShortField(1, (short) value.ordinal());
            }

            public final byte getBattery() {
                return _getByteField(4);
            }

            public final void setBattery(byte value) {
                _setByteField(4, value);
            }

            public final boolean hasCells() {
                return !_pointerFieldIsNull(0);
            }

            public final StructList.Builder<Cell.Builder> getCells() {
                return _getPointerField(Cell.listFactory, 0, null, 0);
            }

            public final void setCells(StructList.Reader<Cell.Reader> value) {
                _setPointerField(Cell.listFactory, 0, value);
            }

            public final StructList.Builder<Cell.Builder> initCells(int size) {
                return _initPointerField(Cell.listFactory, 0, size);
            }

            public final boolean hasAps() {
                return !_pointerFieldIsNull(1);
            }

            public final StructList.Builder<AP.Builder> getAps() {
                return _getPointerField(AP.listFactory, 1, null, 0);
            }

            public final void setAps(StructList.Reader<AP.Reader> value) {
                _setPointerField(AP.listFactory, 1, value);
            }

            public final StructList.Builder<AP.Builder> initAps(int size) {
                return _initPointerField(AP.listFactory, 1, size);
            }
        }

        public static final class Reader extends StructReader {
            Reader(
                SegmentReader segment, int data, int pointers, int dataSize, short pointerCount, int nestingLimit
            ) {
                super(segment, data, pointers, dataSize, pointerCount, nestingLimit);
            }

            public final Type getType() {
                switch (_getShortField(0)) {
                    case 0: return Type.WIFI;
                    case 1: return Type.SOS;
                    default: return Type._NOT_IN_SCHEMA;
                }
            }

            public final Connection getConnection() {
                switch (_getShortField(1)) {
                    case 0: return Connection.GSM;
                    case 1: return Connection.NBIOT;
                    default: return Connection._NOT_IN_SCHEMA;
                }
            }

            public final byte getBattery() {
                return _getByteField(4);
            }

            public final boolean hasCells() {
                return !_pointerFieldIsNull(0);
            }

            public final StructList.Reader<Cell.Reader> getCells() {
                return _getPointerField(Cell.listFactory, 0, null, 0);
            }

            public final boolean hasAps() {
                return !_pointerFieldIsNull(1);
            }

            public final StructList.Reader<AP.Reader> getAps() {
                return _getPointerField(AP.listFactory, 1, null, 0);
            }
        }

        public static class Cell {
            public static final StructSize STRUCT_SIZE = new StructSize((short) 2, (short) 0);
            public static final Factory factory = new Factory();
            public static final StructList.Factory<Builder, Reader> listFactory = new StructList.Factory<>(factory);

            public static final class Factory extends StructFactory<Builder, Reader> {
                public Factory() {
                }

                public final Reader constructReader(
                    SegmentReader segment, int data, int pointers, int dataSize, short pointerCount, int nestingLimit
                ) {
                    return new Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit);
                }

                public final Builder constructBuilder(
                    SegmentBuilder segment, int data, int pointers, int dataSize, short pointerCount
                ) {
                    return new Builder(segment, data, pointers, dataSize, pointerCount);
                }

                public final StructSize structSize() {
                    return Cell.STRUCT_SIZE;
                }

                public final Reader asReader(Builder builder) {
                    return builder.asReader();
                }
            }

            public static final class Builder extends StructBuilder {
                Builder(SegmentBuilder segment, int data, int pointers, int dataSize, short pointerCount) {
                    super(segment, data, pointers, dataSize, pointerCount);
                }

                public final Reader asReader() {
                    return new Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff);
                }

                public final int getCid() {
                    return _getIntField(0);
                }

                public final void setCid(int value) {
                    _setIntField(0, value);
                }

                public final short getLac() {
                    return _getShortField(2);
                }

                public final void setLac(short value) {
                    _setShortField(2, value);
                }

                public final short getMcc() {
                    return _getShortField(3);
                }

                public final void setMcc(short value) {
                    _setShortField(3, value);
                }

                public final short getMnc() {
                    return _getShortField(4);
                }

                public final void setMnc(short value) {
                    _setShortField(4, value);
                }

                public final short getSignal() {
                    return _getShortField(5);
                }

                public final void setSignal(short value) {
                    _setShortField(5, value);
                }
            }

            public static final class Reader extends StructReader {
                Reader(
                    SegmentReader segment, int data, int pointers, int dataSize, short pointerCount, int nestingLimit
                ) {
                    super(segment, data, pointers, dataSize, pointerCount, nestingLimit);
                }

                public final int getCid() {
                    return _getIntField(0);
                }

                public final short getLac() {
                    return _getShortField(2);
                }

                public final short getMcc() {
                    return _getShortField(3);
                }

                public final short getMnc() {
                    return _getShortField(4);
                }

                public final short getSignal() {
                    return _getShortField(5);
                }
            }
        }

        public static class AP {
            public static final StructSize STRUCT_SIZE = new StructSize((short) 1, (short) 1);
            public static final Factory factory = new Factory();
            public static final StructList.Factory<Builder, Reader> listFactory = new StructList.Factory<>(factory);

            public static final class Factory extends StructFactory<Builder, Reader> {
                public Factory() {
                }

                public final Reader constructReader(
                    SegmentReader segment, int data, int pointers, int dataSize, short pointerCount, int nestingLimit
                ) {
                    return new Reader(segment, data, pointers, dataSize, pointerCount, nestingLimit);
                }

                public final Builder constructBuilder(
                    SegmentBuilder segment, int data, int pointers, int dataSize, short pointerCount
                ) {
                    return new Builder(segment, data, pointers, dataSize, pointerCount);
                }

                public final StructSize structSize() {
                    return AP.STRUCT_SIZE;
                }

                public final Reader asReader(Builder builder) {
                    return builder.asReader();
                }
            }

            public static final class Builder extends StructBuilder {
                Builder(
                    SegmentBuilder segment, int data, int pointers, int dataSize, short pointerCount
                ) {
                    super(segment, data, pointers, dataSize, pointerCount);
                }

                public final Reader asReader() {
                    return new Reader(segment, data, pointers, dataSize, pointerCount, 0x7fffffff);
                }

                public final short getSignal() {
                    return _getShortField(0);
                }

                public final void setSignal(short value) {
                    _setShortField(0, value);
                }

                public final boolean hasMac() {
                    return !_pointerFieldIsNull(0);
                }

                public final PrimitiveList.Byte.Builder getMac() {
                    return _getPointerField(PrimitiveList.Byte.factory, 0, null, 0);
                }

                public final void setMac(PrimitiveList.Byte.Reader value) {
                    _setPointerField(PrimitiveList.Byte.factory, 0, value);
                }

                public final PrimitiveList.Byte.Builder initMac(int size) {
                    return _initPointerField(PrimitiveList.Byte.factory, 0, size);
                }
            }

            public static final class Reader extends StructReader {
                Reader(
                    SegmentReader segment, int data, int pointers, int dataSize, short pointerCount, int nestingLimit
                ) {
                    super(segment, data, pointers, dataSize, pointerCount, nestingLimit);
                }

                public final short getSignal() {
                    return _getShortField(0);
                }

                public final boolean hasMac() {
                    return !_pointerFieldIsNull(0);
                }

                public final PrimitiveList.Byte.Reader getMac() {
                    return _getPointerField(PrimitiveList.Byte.factory, 0, null, 0);
                }
            }
        }
    }

    public static final class Schemas {
        public static final SegmentReader b_d989137230f84daf = GeneratedClassSupport.decodeRawBytes(
            "\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00af\u004d\u00f8\u0030\u0072\u0013\u0089\u00d9"
                + "\u000b\u0000\u0000\u0000\u0001\u0000\u0001\u0000"
                + "\u000c\u001f\u007d\u0068\u0083\u007e\u00fd\u00d4"
                + "\u0002\u0000\u0007\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0015\u0000\u0000\u0000\u0082\u0000\u0000\u0000"
                + "\u0019\u0000\u0000\u0000\u0047\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0049\u0000\u0000\u0000\u001f\u0001\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0076\u0074\u0061\u0067\u002e\u0063\u0061\u0070"
                + "\u006e\u0070\u003a\u0057\u0069\u0066\u0069\u0000"
                + "\u0010\u0000\u0000\u0000\u0001\u0000\u0001\u0000"
                + "\u001c\u00cd\u0056\u00e2\u007b\u00a3\u0061\u00d9"
                + "\u0019\u0000\u0000\u0000\u002a\u0000\u0000\u0000"
                + "\u00a3\u0091\u00da\u0062\u00af\u00dd\u0007\u00c0"
                + "\u0015\u0000\u0000\u0000\u005a\u0000\u0000\u0000"
                + "\u003f\u001e\u00d4\u0060\u0023\u0000\u00f3\u009f"
                + "\u0015\u0000\u0000\u0000\u002a\u0000\u0000\u0000"
                + "\u00f1\u00ca\u00d2\u00cd\u0063\u002e\u0087\u00e5"
                + "\u0011\u0000\u0000\u0000\u001a\u0000\u0000\u0000"
                + "\u0054\u0079\u0070\u0065\u0000\u0000\u0000\u0000"
                + "\u0043\u006f\u006e\u006e\u0065\u0063\u0074\u0069"
                + "\u006f\u006e\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0043\u0065\u006c\u006c\u0000\u0000\u0000\u0000"
                + "\u0041\u0050\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0014\u0000\u0000\u0000\u0003\u0000\u0004\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u007d\u0000\u0000\u0000\u002a\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0078\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u0084\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0081\u0000\u0000\u0000\u005a\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0080\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u008c\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0002\u0000\u0000\u0000\u0004\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0002\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0089\u0000\u0000\u0000\u0042\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0084\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u0090\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0003\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0003\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u008d\u0000\u0000\u0000\u0032\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0088\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u00a4\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0004\u0000\u0000\u0000\u0001\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0004\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u00a1\u0000\u0000\u0000\"\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u009c\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u00b8\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0074\u0079\u0070\u0065\u0000\u0000\u0000\u0000"
                + "\u000f\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u001c\u00cd\u0056\u00e2\u007b\u00a3\u0061\u00d9"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u000f\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0063\u006f\u006e\u006e\u0065\u0063\u0074\u0069"
                + "\u006f\u006e\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u000f\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u00a3\u0091\u00da\u0062\u00af\u00dd\u0007\u00c0"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u000f\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0062\u0061\u0074\u0074\u0065\u0072\u0079\u0000"
                + "\u0002\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0002\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0063\u0065\u006c\u006c\u0073\u0000\u0000\u0000"
                + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u003f\u001e\u00d4\u0060\u0023\u0000\u00f3\u009f"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0061\u0070\u0073\u0000\u0000\u0000\u0000\u0000"
                + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u0010\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u00f1\u00ca\u00d2\u00cd\u0063\u002e\u0087\u00e5"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000");
        public static final SegmentReader b_d961a37be256cd1c = GeneratedClassSupport.decodeRawBytes(
            "\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u001c\u00cd\u0056\u00e2\u007b\u00a3\u0061\u00d9"
                + "\u0010\u0000\u0000\u0000\u0002\u0000\u0000\u0000"
                + "\u00af\u004d\u00f8\u0030\u0072\u0013\u0089\u00d9"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0015\u0000\u0000\u0000\u00aa\u0000\u0000\u0000"
                + "\u001d\u0000\u0000\u0000\u0007\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0019\u0000\u0000\u0000\u0037\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0076\u0074\u0061\u0067\u002e\u0063\u0061\u0070"
                + "\u006e\u0070\u003a\u0057\u0069\u0066\u0069\u002e"
                + "\u0054\u0079\u0070\u0065\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000"
                + "\u0008\u0000\u0000\u0000\u0001\u0000\u0002\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0011\u0000\u0000\u0000\u002a\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0009\u0000\u0000\u0000\"\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0077\u0069\u0066\u0069\u0000\u0000\u0000\u0000"
                + "\u0073\u006f\u0073\u0000\u0000\u0000\u0000\u0000");
        public static final SegmentReader b_c007ddaf62da91a3 = GeneratedClassSupport.decodeRawBytes(
            "\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00a3\u0091\u00da\u0062\u00af\u00dd\u0007\u00c0"
                + "\u0010\u0000\u0000\u0000\u0002\u0000\u0000\u0000"
                + "\u00af\u004d\u00f8\u0030\u0072\u0013\u0089\u00d9"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0015\u0000\u0000\u0000\u00da\u0000\u0000\u0000"
                + "\u0021\u0000\u0000\u0000\u0007\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u001d\u0000\u0000\u0000\u0037\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0076\u0074\u0061\u0067\u002e\u0063\u0061\u0070"
                + "\u006e\u0070\u003a\u0057\u0069\u0066\u0069\u002e"
                + "\u0043\u006f\u006e\u006e\u0065\u0063\u0074\u0069"
                + "\u006f\u006e\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000"
                + "\u0008\u0000\u0000\u0000\u0001\u0000\u0002\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0011\u0000\u0000\u0000\"\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0009\u0000\u0000\u0000\u0032\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0067\u0073\u006d\u0000\u0000\u0000\u0000\u0000"
                + "\u006e\u0062\u0069\u006f\u0074\u0000\u0000\u0000");
        public static final SegmentReader b_9ff3002360d41e3f = GeneratedClassSupport.decodeRawBytes(
            "\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u003f\u001e\u00d4\u0060\u0023\u0000\u00f3\u009f"
                + "\u0010\u0000\u0000\u0000\u0001\u0000\u0002\u0000"
                + "\u00af\u004d\u00f8\u0030\u0072\u0013\u0089\u00d9"
                + "\u0000\u0000\u0007\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0015\u0000\u0000\u0000\u00aa\u0000\u0000\u0000"
                + "\u001d\u0000\u0000\u0000\u0007\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0019\u0000\u0000\u0000\u001f\u0001\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0076\u0074\u0061\u0067\u002e\u0063\u0061\u0070"
                + "\u006e\u0070\u003a\u0057\u0069\u0066\u0069\u002e"
                + "\u0043\u0065\u006c\u006c\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000"
                + "\u0014\u0000\u0000\u0000\u0003\u0000\u0004\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u007d\u0000\u0000\u0000\"\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0078\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u0084\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0001\u0000\u0000\u0000\u0002\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0081\u0000\u0000\u0000\"\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u007c\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u0088\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0002\u0000\u0000\u0000\u0003\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0002\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0085\u0000\u0000\u0000\"\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0080\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u008c\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0003\u0000\u0000\u0000\u0004\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0003\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u0089\u0000\u0000\u0000\"\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0084\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u0090\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0004\u0000\u0000\u0000\u0005\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0004\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u008d\u0000\u0000\u0000\u003a\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0088\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u0094\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0063\u0069\u0064\u0000\u0000\u0000\u0000\u0000"
                + "\u0004\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0004\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u006c\u0061\u0063\u0000\u0000\u0000\u0000\u0000"
                + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u006d\u0063\u0063\u0000\u0000\u0000\u0000\u0000"
                + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u006d\u006e\u0063\u0000\u0000\u0000\u0000\u0000"
                + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0007\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0073\u0069\u0067\u006e\u0061\u006c\u0000\u0000"
                + "\u0003\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0003\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000");
        public static final SegmentReader b_e5872e63cdd2caf1 = GeneratedClassSupport.decodeRawBytes(
            "\u0000\u0000\u0000\u0000\u0005\u0000\u0006\u0000" + "\u00f1\u00ca\u00d2\u00cd\u0063\u002e\u0087\u00e5"
                + "\u0010\u0000\u0000\u0000\u0001\u0000\u0001\u0000"
                + "\u00af\u004d\u00f8\u0030\u0072\u0013\u0089\u00d9"
                + "\u0001\u0000\u0007\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0015\u0000\u0000\u0000\u009a\u0000\u0000\u0000"
                + "\u001d\u0000\u0000\u0000\u0007\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0019\u0000\u0000\u0000\u0077\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0076\u0074\u0061\u0067\u002e\u0063\u0061\u0070"
                + "\u006e\u0070\u003a\u0057\u0069\u0066\u0069\u002e"
                + "\u0041\u0050\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000"
                + "\u0008\u0000\u0000\u0000\u0003\u0000\u0004\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0029\u0000\u0000\u0000\u003a\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0024\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u0030\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0001\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000" + "\u002d\u0000\u0000\u0000\"\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0028\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u0044\u0000\u0000\u0000\u0002\u0000\u0001\u0000"
                + "\u0073\u0069\u0067\u006e\u0061\u006c\u0000\u0000"
                + "\u0003\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0003\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u006d\u0061\u0063\u0000\u0000\u0000\u0000\u0000"
                + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0003\u0000\u0001\u0000"
                + "\u0002\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u000e\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                + "\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000");
    }
}

