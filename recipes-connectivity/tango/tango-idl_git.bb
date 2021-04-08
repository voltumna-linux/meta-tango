DESCRIPTION = "Tango CORBA IDL file"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-3.0;md5=bfccfe952269fff2b407dd11f2f3083b"

SRCREV = "ada81f822b9d24c0bb2d7d250896e9521368f681"
SRC_URI = "git://gitlab.com/tango-controls/${BPN}.git;protocol=https;branch=main"

S = "${WORKDIR}/git"

inherit cmake
