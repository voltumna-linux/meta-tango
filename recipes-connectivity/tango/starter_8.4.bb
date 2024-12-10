DESCRIPTION = "Tango Starter"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS += "cpptango"

SRC_URI = "git://gitlab.com/tango-controls/${BPN}.git;name=starter;protocol=https;branch=main \
	git://gitlab.com/tango-controls/TangoCMakeModules.git;destsuffix=git/TangoCMakeModules;name=cmakemodules;protocol=https;branch=main \
	file://01-log-file-home-no-ds.log.patch \
	file://02-starter-stdout.patch \
	file://starter.service \
	"
SRCREV_starter = "2c40d9086e4b95e2fea14d0e519667aaa77b68de"
SRCREV_cmakemodules = "dfc42901855bc7aae72a132e6f3373bab8660747"
SRCREV_FORMAT = "starter_cmakemodules"

S = "${WORKDIR}/git"

FILES_${PN} += "${bindir}"

SYSTEMD_SERVICE_${PN} = "starter.service"

do_install_append() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/starter.service ${D}${systemd_unitdir}/system
}

inherit pkgconfig systemd cmake
