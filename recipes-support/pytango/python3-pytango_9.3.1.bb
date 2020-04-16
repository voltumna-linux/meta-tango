SUMMARY = "Tango for Python"
DESCRIPTION = "PyTango is a python module that exposes to Python the complete Tango C++ API"
HOMEPAGE = "https://pytango.readthedocs.io/"

LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e6a600fd5e1d9cbde2d983680233ad02"


S = "${WORKDIR}/git"
SRCREV = "0c31693f67c4e2db12128f7a9db439295dfe889c"

SRC_URI = " \
    git://github.com/tango-controls/pytango.git;protocol=https;branch=develop \
    file://remove-distro-usages.patch \
    "

DEPENDS += "\
    boost \
    libtango \
    "

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-numpy \
    ${PYTHON_PN}-six \
    "

inherit setuptools3
