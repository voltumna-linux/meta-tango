SUMMARY = "Tango for Python"
DESCRIPTION = "PyTango is a python module that exposes to Python the complete Tango C++ API"
HOMEPAGE = "https://pytango.readthedocs.io/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=855580e1a55a9af704c90fae138fe0d1"

DEFAULT_PREFERENCE = "-1"

DEPENDS += "\
	boost \
	cpptango \
	${PYTHON_PN}-numpy-native \
	${PYTHON_PN}-build-native \
	${PYTHON_PN}-scikit-build-native \
	${PYTHON_PN}-pybind11-native \
	"

SRC_URI = "git://gitlab.com/tango-controls/pytango.git;name=pytango;protocol=https;branch=develop \
	git://gitlab.com/tango-controls/TangoCMakeModules.git;destsuffix=git/TangoCMakeModules;name=cmakemodules;protocol=https;branch=main \
	"
SRCREV_pytango = "82dff8fe0150a5e57699a7c413bb7367cb6c76c7"
SRCREV_cmakemodules = "c3945dbd4b01931b5c1191ed662f69857ff0db70"
SRCREV_FORMAT = "pytango_cmakemodules"

S = "${WORKDIR}/git"

FILES_${PN} += " ${PYTHON_SITEPACKAGES_DIR}"
do_install() {
	install -d ${D}${PYTHON_SITEPACKAGES_DIR}

	install -m 0644 ${S}/PyTango/__init__.py ${D}${PYTHON_SITEPACKAGES_DIR}/PyTango.py
	cp -r ${S}/tango ${D}${PYTHON_SITEPACKAGES_DIR}
	rm -fr ${D}${PYTHON_SITEPACKAGES_DIR}/tango/databaseds
	PYTHON_LIBVER="$(echo ${PYTHON_BASEVERSION} | sed 's/\([0-9]*\).\([0-9]*\)/\1\2/g')"
	install -m 0755 ${B}/_tango.so.${PV} ${D}${PYTHON_SITEPACKAGES_DIR}/tango/_tango.cpython-${PYTHON_LIBVER}-${BUILD_SYS}-gnu.so

	${PYTHON_PN} ${STAGING_LIBDIR}/${PYTHON_DIR}/py_compile.py ${D}${PYTHON_SITEPACKAGES_DIR}/PyTango.py
	${PYTHON_PN} ${STAGING_LIBDIR}/${PYTHON_DIR}/py_compile.py ${D}${PYTHON_SITEPACKAGES_DIR}/tango/*.py
}

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-numpy \
    ${PYTHON_PN}-packaging \
    ${PYTHON_PN}-psutil \
    "

inherit pkgconfig cmake python3native python3targetconfig

BBCLASSEXTEND = "nativesdk"
