run-dist:
	make -C app run-dist

build:
	make -C app build

install:
	make -C app install

run:
	make -C app run

test:
	make -C app test

lint:
	make -C app lint

report:
	make -C app report

build-run:
	make -C app build-run

clean:
	make -C app clean