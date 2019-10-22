DESCRIPTION = "TANGO is an object oriented distributed control system using CORBA (synchronous and asynchronous communication) and zeromq (event based communication)"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c9432eab6a070a936cf9da6191d6db6"

DEPENDS += "omniorb-native omniorb tango-idl cppzmq"

SRCREV = "9c8837fb34e552789673cf386a5b31f83c29e504"
SRC_URI = "git://github.com/tango-controls/cppTango.git;protocol=https;branch=tango-9-lts \
		file://disable-mmx.patch \
		file://disable-testing.patch \
	"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " -DIDL_BASE=${PKG_CONFIG_SYSROOT_DIR}/usr"

inherit cmake python3native pkgconfig
