### Main Makefile for USACO solutions ###

PROBLEM_NAME = hiho_mstest2015oct_1_beautifulstring

.PHONY: $(PROBLEM_NAME)
$(PROBLEM_NAME):
	$(MAKE) -C $(PROBLEM_NAME)

run:	$(PROBLEM_NAME)
	$(MAKE) -C $(PROBLEM_NAME) run

all:	$(PROBLEM_NAME)

clean:
	for subdir in */ ; do rm -f $$subdir/*.o; done
	for subdir in */ ; do rm -f $$subdir/*.exe; done
	for subdir in */ ; do rm -f $$subdir/*.out; done
	
