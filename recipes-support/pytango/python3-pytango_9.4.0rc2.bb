SUMMARY = "Tango for Python"
DESCRIPTION = "PyTango is a python module that exposes to Python the complete Tango C++ API"
HOMEPAGE = "https://pytango.readthedocs.io/"

LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9b80b59e376a3d99efcebbbcfa349133"

PYPI_PACKAGE = "pytango"
SRC_URI[sha256sum] = "306dade110d5fc9d96c23eebe759e9cfc2daac48c8331d2ce675214c1fcf557e"

SRC_URI = " \
    file://force-boost_library_name.patch \
    "

DEPENDS += "\
    boost \
    cpptango \
    ${PYTHON_PN}-numpy-native \
    "

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-numpy \
    ${PYTHON_PN}-six \
    "

inherit pypi pkgconfig setuptools3

BBCLASSEXTEND = "native nativesdk"
