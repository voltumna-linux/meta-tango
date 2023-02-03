DESCRIPTION = "Tango Starter"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

DEPENDS += "cpptango"

SRCREV = "eb055ee567ff2fae0ed8d0c8ed17513adf2583ac"
SRC_URI = "git://gitlab.com/tango-controls/${BPN}.git;protocol=https;branch=main \
		file://01-log-file-home-no-ds.log.patch \
		file://02-starter-stdout.patch \
		file://starter.service \
	"

S = "${WORKDIR}/git"

FILES:${PN} += "${bindir}"

SYSTEMD_SERVICE:${PN} = "starter.service"

do_install:append() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/starter.service ${D}${systemd_unitdir}/system
}

inherit cmake pkgconfig systemd
