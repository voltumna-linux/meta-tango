DESCRIPTION = "OmniORB High Performance ORB"
HOMEPAGE = "http://omniorb.sourceforge.net"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=1b422f7cda3870b9c4b040b68ba1c0fe"

DEPENDS += "omniorb-native python3"

SRC_URI = "http://downloads.sourceforge.net/omniorb/omniORB-${PV}.tar.bz2"
SRC_URI[sha256sum] = "f05cf999fb2f4c24c1173b3c44ad97215591d0d1a48d49ac0843c464efe073bb"

SRC_URI:append = "\
    file://0001-beforeauto-cross.patch \
    file://0002-python-shebang.patch \
    file://0003-embedded-appl.patch \
    file://0004-remove-distutils-usage.patch \
"

S = "${WORKDIR}/omniORB-${PV}"

EXTRA_OECONF += "--disable-longdouble"

CONFFILES:${PN} += "/etc/omniORB.cfg"
FILES:${PN}-dev += "${libdir}/python${PYTHON_BASEVERSION}"

do_compile () {
	export TOOLBINDIR=${STAGING_BINDIR_NATIVE}
	oe_runmake
}

do_compile:class-native () {
	oe_runmake
}

do_install:append () {
	install -d ${D}${sysconfdir}
	install -m 0644 ${S}/sample.cfg ${D}${sysconfdir}/omniORB.cfg

	# Set sane defaults
	sed -i 's,^traceThreadId.*,traceThreadId = 0,g' ${D}${sysconfdir}/omniORB.cfg
	sed -i 's,^traceTime.*,traceTime = 0,g' ${D}${sysconfdir}/omniORB.cfg
}

PARALLEL_MAKE = ""
INSANE_SKIP:${PN} += "patch-status"
INSANE_SKIP:${PN}-native += "patch-status"

inherit autotools python3native pkgconfig

BBCLASSEXTEND = "native nativesdk"
