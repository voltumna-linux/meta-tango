DESCRIPTION = "TANGO is an object oriented distributed control system using CORBA \
(synchronous and asynchronous communication) and zeromq (event based communication)"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-3.0;md5=bfccfe952269fff2b407dd11f2f3083b"

DEPENDS += "cpptango"

SRCREV = "bbf08fdcc8c6bf12914c670cfaff18b1838ed779"
SRC_URI = "git://gitlab.com/tango-controls/C_Binding.git;protocol=https;branch=master \
	file://ctango_Makefile.patch \
	"

S = "${WORKDIR}/git"

do_compile() {
	oe_runmake "TANGO_HOME=${PKG_CONFIG_SYSROOT_DIR}${prefix}" "OS=" "INSTALL_BASE=${D}${prefix}" libc_tango.so
}

do_install() {
	oe_runmake "TANGO_HOME=${PKG_CONFIG_SYSROOT_DIR}${prefix}" "OS=" "INSTALL_BASE=${D}${prefix}"
}

BBCLASSEXTEND = "nativesdk"
