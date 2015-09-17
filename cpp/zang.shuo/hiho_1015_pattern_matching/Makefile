CXXFLAGS =	-g -Wall -fmessage-length=0

OBJS =		kmp.o

LIBS =

TARGET =	kmp.exe

$(TARGET):	$(OBJS)
	$(CXX) -o $(TARGET) $(OBJS) $(LIBS)

run:	$(TARGET)
	./$(TARGET)

all:	$(TARGET)

clean:
	rm -f $(OBJS) $(TARGET)
