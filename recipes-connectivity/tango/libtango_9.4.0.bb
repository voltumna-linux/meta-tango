DESCRIPTION = "TANGO is an object oriented distributed control system using CORBA (synchronous and asynchronous communication) and zeromq (event based communication)"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c9432eab6a070a936cf9da6191d6db6"

DEPENDS += "omniorb-native omniorb tango-idl cppzmq libjpeg-turbo"

SRCREV = "d18738decc5ef1fb48189b04a61b627ca34ff1f8"
SRC_URI = "git://gitlab.com/tango-controls/cppTango.git;protocol=https;branch=main \
	"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " -DTANGO_IDL_BASE=${PKG_CONFIG_SYSROOT_DIR}/usr -DCMAKE_BUILD_TYPE=Release -DBUILD_TESTING=OFF"

inherit cmake python3native pkgconfig
