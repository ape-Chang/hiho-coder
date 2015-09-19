CXXFLAGS =	-g -Wall -pg -fmessage-length=0

OBJS =		solution.o

LIBS =

TARGET =	solution.exe

$(TARGET):	$(OBJS)
	$(CXX) -pg -o $(TARGET) $(OBJS) $(LIBS)
	
run:	$(TARGET)
	./$(TARGET)

all:	$(TARGET)

clean:
	rm -f $(OBJS) $(TARGET)
