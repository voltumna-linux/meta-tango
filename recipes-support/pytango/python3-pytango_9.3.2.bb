SUMMARY = "Tango for Python"
DESCRIPTION = "PyTango is a python module that exposes to Python the complete Tango C++ API"
HOMEPAGE = "https://pytango.readthedocs.io/"

LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e6a600fd5e1d9cbde2d983680233ad02"


S = "${WORKDIR}/git"
SRCREV = "8fbf0a29e26be2723b63a704a1a8e0664f671946"

SRC_URI = " \
    git://github.com/tango-controls/pytango.git;protocol=https;branch=develop \
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
