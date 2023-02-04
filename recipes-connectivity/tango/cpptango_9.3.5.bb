DESCRIPTION = "TANGO is an object oriented distributed control system using CORBA \
(synchronous and asynchronous communication) and zeromq (event based communication)"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c9432eab6a070a936cf9da6191d6db6"

DEPENDS += "omniorb-native omniorb tango-idl cppzmq libjpeg-turbo doxygen-native graphviz-native"

SRCREV = "a413298ed9433845c949616eec500dfe24ef0647"
SRC_URI = "git://gitlab.com/tango-controls/cppTango.git;protocol=https;branch=9.3-backports \
	file://disable-mmx.patch \
"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " -DIDL_BASE=${STAGING_EXECPREFIXDIR} -DCMAKE_BUILD_TYPE=Release \
	-DBUILD_TESTING=OFF -DOMNIIDL_TEST_RUN=0"
EXTRA_OECMAKE_BUILD = "doc"

do_install_append() {
	install -d ${D}${docdir}/${BPN}
	cp -R ${B}/doc_html ${D}${docdir}/${BPN}/
}

inherit cmake python3native pkgconfig

BBCLASSEXTEND = "native nativesdk"
