DESCRIPTION = "Tango CORBA IDL file"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-3.0;md5=bfccfe952269fff2b407dd11f2f3083b"

SRCREV = "1e5edb84d966814ad367f2674ac9a5658b6724ac"
SRC_URI = "git://github.com/tango-controls/${BPN}.git;protocol=https;branch=tango-9-lts"

S = "${WORKDIR}/git"

inherit cmake
