RM := rm
CXX := g++
CXXWARNFLAGS := -Wall
CXXFLAGS := $(CXXWARNFLAGS) -std=c++11
BIN_NAME := hiho
SRC := $(wildcard *.cpp)

.phony: clean
$(BIN_NAME): $(SRC)
	$(CXX) $(CXXFLAGS) $(SRC) -o $(BIN_NAME)
clean:
	-@$(RM) $(BIN_NAME)