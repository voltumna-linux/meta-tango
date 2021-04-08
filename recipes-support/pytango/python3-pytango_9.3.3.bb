SUMMARY = "Tango for Python"
DESCRIPTION = "PyTango is a python module that exposes to Python the complete Tango C++ API"
HOMEPAGE = "https://pytango.readthedocs.io/"

LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e6a600fd5e1d9cbde2d983680233ad02"


S = "${WORKDIR}/git"
SRCREV = "31a8d9e25cea700fa04e77ddc8a605b5889d332d"

SRC_URI = " \
    git://gitlab.com/tango-controls/pytango.git;protocol=https;branch=stable \
    file://force-boost_library_name.patch \
    "

DEPENDS += "\
    boost \
    libtango \
    ${PYTHON_PN}-numpy \
    "

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-numpy \
    ${PYTHON_PN}-six \
    "

inherit setuptools3
