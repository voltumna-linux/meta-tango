DESCRIPTION = "OmniORB High Performance ORB"
HOMEPAGE = "http://omniorb.sourceforge.net"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=1b422f7cda3870b9c4b040b68ba1c0fe"

DEPENDS += "omniorb-native python3"

SRC_URI = "http://downloads.sourceforge.net/omniorb/omniORB-${PV}.tar.bz2"
SRC_URI[md5sum] = "de961e8aa29f3eed95ea40a94c1cccdf"
SRC_URI[sha256sum] = "28c01cd0df76c1e81524ca369dc9e6e75f57dc70f30688c99c67926e4bdc7a6f"

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

	# Set sane defaults
	sed -i 's,^traceThreadId.*,traceThreadId = 0,g' ${D}${sysconfdir}/omniORB.cfg
	sed -i 's,^traceTime.*,traceTime = 0,g' ${D}${sysconfdir}/omniORB.cfg
}

inherit autotools python3native pkgconfig

BBCLASSEXTEND = "native"
