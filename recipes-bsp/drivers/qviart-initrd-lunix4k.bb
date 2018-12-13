SRCDATE = "20180917"

require qviart-initrd.inc

do_install() {
    install -d ${D}/boot
    install -m 0755 ${WORKDIR}/vmlinuz-initrd-7260a0 ${D}/boot/initrd_run.bin
}

SRC_URI[md5sum] = "5a6aa02e8f383204e015247bda3e2841"
SRC_URI[sha256sum] = "26e840249bf551f2a5b5c5f093b90848c6ec5af290cc492ad903bcfd277a1047"
