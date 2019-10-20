package com.t4.LiveServer.controller;

import com.t4.LiveServer.business.interfaze.StreamBusiness;
import com.t4.LiveServer.core.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/stream"})
public class StreamController {

    @Autowired
    StreamBusiness streamBusiness;

    public StreamController() {
    }

    @PostMapping("/create")
    public ApiResponse createLiveStream() {
        ApiResponse response = new ApiResponse();
        response.statusCode = 200;
        response.message="create live stream success!";
        response.dataAsString = streamBusiness.create();
        return response;
    }

    @GetMapping("/fetchAll")
    public ApiResponse fetchAllLiveStream() {
        ApiResponse response = new ApiResponse();
        response.statusCode = 200;
        response.message="fetch all live stream!";
        response.dataAsString = streamBusiness.fetchAll();
        return response;
    }

    @GetMapping("/fetch/{id}")
    public ApiResponse fetchALiveStream(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.dataAsString = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "fetch one live stream!";
        response.dataAsString = streamBusiness.fetchOne(id);
        return response;
    }

    @PatchMapping("/update")
    public ApiResponse updateALiveStream() {
        ApiResponse response = new ApiResponse();
        response.statusCode = 400;
        response.message = "TBD!";
        response.dataAsString = null;
        response.errorCode = 1;
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteALiveStream(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.dataAsString = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "delete one live stream!";
        response.dataAsString = streamBusiness.delete(id);
        return response;
    }

    @PutMapping("/start/{id}")
    public ApiResponse startALiveStream(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.dataAsString = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "delete one live stream!";
        response.dataAsString = streamBusiness.delete(id);
        return response;
    }

    @PutMapping("/stop/{id}")
    public ApiResponse stopALiveStream(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.dataAsString = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "stop one live stream!";
        response.dataAsString = streamBusiness.stop(id);
        return response;
    }

    @PutMapping("/reset/{id}")
    public ApiResponse resetALiveStream(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.dataAsString = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "reset one live stream!";
        response.dataAsString = streamBusiness.reset(id);
        return response;
    }

    @PutMapping("/regenerateCode/{id}")
    public ApiResponse regenerateConnectionCode(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.dataAsString = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "regenerate connection code!";
        response.dataAsString = streamBusiness.regenerate(id);
        return response;
    }

    @GetMapping("/fetchThumbnail/{id}")
    public ApiResponse fetchThumbnailURL(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.dataAsString = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "fetch thumbnail!";
        response.dataAsString = streamBusiness.fetchThumbnail(id);
        return response;
    }

    @GetMapping("/fetchState/{id}")
    public ApiResponse fetchState(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.dataAsString = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "fetch state live stream!";
        response.dataAsString = streamBusiness.fetchState(id);
        return response;
    }

    @GetMapping("/fetchMetrics/{id}")
    public ApiResponse fetchMetrics(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.dataAsString = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "fetch metrics live stream!";
        response.dataAsString = streamBusiness.fetchMetrics(id);
        return response;
    }

    @GetMapping("/versions")
    public ApiResponse getVersionsApi() {
        ApiResponse response = new ApiResponse();
        response.statusCode = 200;
        response.message = "fetch versions live stream!";
        response.dataAsString = streamBusiness.fetchVersions();
        return response;

    }
}
