DESCRIPTION = "Tango Starter"
HOMEPAGE = "http://www.tango-controls.org"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

DEPENDS += "cpptango"

SRCREV = "ed193937fdfdeae6527cc6aa499ef821dea0c1d1"
SRC_URI = "git://gitlab.com/tango-controls/${BPN}.git;protocol=https;branch=main \
		file://01-log-file-home-no-ds.log.patch \
		file://02-starter-stdout.patch \
		file://starter.service \
	"

S = "${WORKDIR}/git"

FILES_${PN} += "${bindir}"

SYSTEMD_SERVICE_${PN} = "starter.service"

do_install_append() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/starter.service ${D}${systemd_unitdir}/system
}

inherit pkgconfig systemd cmake
