@0xd4fd7e83687d1f0c;

using Java = import "java.capnp";
$Java.package("com.viettel.vtag");
$Java.outerClassname("Messages");

struct Wifi {
    type       @0 : Type;
    connection @1 : Connection;
    battery    @2 : Int8;
    cells      @3 : List(Cell);
    aps        @4 : List(AP);

    enum Type {
        wifi @0;
        sos  @1;
    }

    enum Connection {
        gsm   @0;
        nbiot @1;
    }

    struct Cell {
        cid    @0 : Int32;
        lac    @1 : UInt16;
        mcc    @2 : UInt16;
        mnc    @3 : UInt16;
        signal @4 : Int16;
    }

    struct AP {
        signal @0 : Int16;
        mac    @1 : List(Int8);
    }
}
