SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

PACKAGE_ARCH = "${MACHINE}"

SRCDATE = "20200717"
KV = "4.1.20"
PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI[md5sum] = "dff8d9800fbc7c978bc6a0c17ce41838"
SRC_URI[sha256sum] = "a31e45fb03ee2bb22eef8908ce06ce5c5cf303e6c0614a37f5bc6b1effd31ee9"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_72604-${KV}-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_compile() {
}

do_populate_sysroot() {
}

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    cp -Rf ${WORKDIR}/lib/modules/${KV}/extra/*.ko ${D}/lib/modules/${KV}/extra/
}

FILES_${PN} += "/lib/modules/${KV}/extra"
