DESCRIPTION = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.1.20"
KV_EXTRA = ""
PV = "${KV}+${SRCDATE}"

SRCDATE = "20190403"

SRC_URI = "http://en3homeftp.net/release/images/oedrivers/bcmlinuxdvb_${CHIP}-${KV}-noproxy-${SRCDATE}.tar.gz"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

do_compile() {
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"

do_install() {
		install -d ${D}/lib/modules/${KV}/extra
		for f in ${S}/lib/modules/${KV}/extra/*.ko; do
			install -m 0644 $f ${D}/lib/modules/${KV}/extra;
		done
		install -d ${D}/${sysconfdir}/modules-load.d
		for i in `ls ${D}/lib/modules/${KV}/extra | grep \\.ko | sed -e 's/.ko//g'`; do
		    echo $i _hwtype=\$hwtypenum >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
		done
}
SRC_URI[md5sum] = "9ea6bc619dbb0444b896d0228cbd8436"
SRC_URI[sha256sum] = "eecfc29536daffee989dd5605051adb3699afa7b7a3590fcda085101a1cb7bbe"
