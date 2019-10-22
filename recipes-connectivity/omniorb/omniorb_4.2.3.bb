DESCRIPTION = "OmniORB High Performance ORB"
HOMEPAGE = "http://omniorb.sourceforge.net"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=1b422f7cda3870b9c4b040b68ba1c0fe"

DEPENDS += "omniorb-native python3"

SRC_URI = "http://downloads.sourceforge.net/omniorb/omniORB-${PV}.tar.bz2"
SRC_URI[md5sum] = "10a30bae5e1fb4563b47891c6cdf2b5c"
SRC_URI[sha256sum] = "26412ac08ab495ce5a6a8e40961fa20b7c43f623c6c26b616d210ca32f078bca"

SRC_URI_append = "\
    file://0001-beforeauto-cross.patch \
    file://0002-python-shebang.patch \
    file://0003-embedded-appl.patch \
"

S = "${WORKDIR}/omniORB-${PV}"

EXTRA_OECONF += "--disable-longdouble"

CONFFILES_${PN} += "/etc/omniORB.cfg"
FILES_${PN}-dev += "${libdir}/python${PYTHON_BASEVERSION}"

do_compile () {
	export TOOLBINDIR=${STAGING_BINDIR_NATIVE}
	oe_runmake
}

do_compile_class-native () {
	oe_runmake
}

do_install_append () {
	install -d ${D}${sysconfdir}
	install -m 0644 ${S}/sample.cfg ${D}${sysconfdir}/omniORB.cfg
}

inherit autotools python3native pkgconfig

BBCLASSEXTEND = "native"
