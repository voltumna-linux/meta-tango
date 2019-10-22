DESCRIPTION = "Tango CORBA IDL file"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-3.0;md5=bfccfe952269fff2b407dd11f2f3083b"

SRCREV = "03e0e74783f68231dee55935dff7a3ad1abeb195"
SRC_URI = "git://github.com/tango-controls/${BPN}.git;protocol=https;branch=tango-9-lts"

S = "${WORKDIR}/git"

inherit cmake
