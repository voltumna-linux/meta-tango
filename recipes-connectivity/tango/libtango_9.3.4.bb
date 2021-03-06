DESCRIPTION = "TANGO is an object oriented distributed control system using CORBA (synchronous and asynchronous communication) and zeromq (event based communication)"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c9432eab6a070a936cf9da6191d6db6"

DEPENDS += "omniorb-native omniorb tango-idl cppzmq"

SRCREV = "ef0c2be4a3223cbdbcd9521fc66eb8d7363cca87"
SRC_URI = "git://gitlab.com/tango-controls/cppTango.git;protocol=https;branch=9.3-backports \
	file://disable-mmx.patch \
	"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " -DIDL_BASE=${PKG_CONFIG_SYSROOT_DIR}/usr -DCMAKE_BUILD_TYPE=Release -DBUILD_TESTING=OFF"

inherit cmake python3native pkgconfig
