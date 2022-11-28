DESCRIPTION = "Tango CORBA IDL file"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c9432eab6a070a936cf9da6191d6db6"

SRCREV = "e4cfb92fbba847ddf112f36fc82d13118dd5141b"
SRC_URI = "git://gitlab.com/tango-controls/${BPN}.git;protocol=https;branch=main"

S = "${WORKDIR}/git"

inherit cmake
