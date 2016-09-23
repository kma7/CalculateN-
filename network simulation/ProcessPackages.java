package ds.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Request {
	public int arrival_time;
	public int process_time;
	
	public Request(int arrival_time, int process_time) {
		this.arrival_time = arrival_time;
        this.process_time = process_time;
	}
}

class Response {
	public boolean dropped;
	public int start_time;
	
	public Response(boolean dropped, int start_time) {
        this.dropped = dropped;
        this.start_time = start_time;
    }
}

class Buffer {
	private int size_;
	private ArrayList<Integer> finish_time_;
	public int lastProcessTime;
	
	public Buffer(int size) {
        this.size_ = size;
        this.finish_time_ = new ArrayList<Integer>();
    }
	
    public Response Process(Request request) {
    	//First request is processed immediately
    	if(this.finish_time_.size() == 0) {
    		this.size_--;
    		this.finish_time_.add(request.arrival_time + request.process_time);
    		return new Response(false, request.arrival_time);
    	}
    	//Buffer size adjustment according to request's arrival time
    	for(int i = 0; i < this.finish_time_.size(); i++) {
			if(request.arrival_time >= this.finish_time_.get(i)) {
				this.size_++;
			}
		}
    	//Process current request
		this.size_--;
		lastProcessTime = this.finish_time_.get(this.finish_time_.size() - 1);
		if(this.size_ >= 0) {
			if(request.arrival_time >= lastProcessTime){
				this.finish_time_.add(request.arrival_time + request.process_time);
        		return new Response(false, request.arrival_time);
    		}else {
    			this.finish_time_.add(lastProcessTime + request.process_time);
    			return new Response(false, lastProcessTime);
    		}
		} else {//dropped, release current request
			this.size_++;
		}
    	
        return new Response(false, -1);
    }
}

public class ProcessPackages {

	private static ArrayList<Request> ReadQueries(Scanner scanner) throws IOException {
        int requests_count = scanner.nextInt();
        ArrayList<Request> requests = new ArrayList<Request>();
        for (int i = 0; i < requests_count; ++i) {
            int arrival_time = scanner.nextInt();
            int process_time = scanner.nextInt();
            requests.add(new Request(arrival_time, process_time));
        }
        return requests;
    }

    private static ArrayList<Response> ProcessRequests(ArrayList<Request> requests, Buffer buffer) {
        ArrayList<Response> responses = new ArrayList<Response>();
        for (int i = 0; i < requests.size(); ++i) {
            responses.add(buffer.Process(requests.get(i)));
        }
        return responses;
    }

    private static void PrintResponses(ArrayList<Response> responses) {
        for (int i = 0; i < responses.size(); ++i) {
            Response response = responses.get(i);
            if (response.dropped) {
                System.out.println(-1);
            } else {
                System.out.println(response.start_time);
            }
        }
    }
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        int buffer_max_size = scanner.nextInt();
        Buffer buffer = new Buffer(buffer_max_size);

        ArrayList<Request> requests = ReadQueries(scanner);
        ArrayList<Response> responses = ProcessRequests(requests, buffer);
        PrintResponses(responses);
	}

}
