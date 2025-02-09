package com.t4.LiveServer.controller;

import com.t4.LiveServer.business.interfaze.wowza.WOWZAStreamBusiness;
import com.t4.LiveServer.core.ApiResponse;
import com.t4.LiveServer.entryParam.base.Wowza.AdditionOutputStreamTargetToTransCoderEntryParam;
import com.t4.LiveServer.model.wowza.StreamTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/test/wowza/streams"})
public class TestWOWZAStreamController {

    @Autowired
    WOWZAStreamBusiness WOWZAStreamBusiness;

    public TestWOWZAStreamController() {
    }

//    @PostMapping("/create")
//    public ApiResponse createLiveStream() {
//        ApiResponse response = new ApiResponse();
//        response.statusCode = 200;
//        response.message="create live stream success!";
//        response.data = WOWZAStreamBusiness.create("auto genrating name : " + System.currentTimeMillis());
//        return response;
//    }

    @GetMapping("/fetchAll")
    public ApiResponse fetchAllLiveStream() {
        ApiResponse response = new ApiResponse();
        response.statusCode = 200;
        response.message="fetch all live stream!";
        response.data = WOWZAStreamBusiness.fetchAll();
        return response;
    }

    @GetMapping("/fetch/{id}")
    public ApiResponse fetchALiveStream(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "fetch one live stream!";
        response.data = WOWZAStreamBusiness.fetchOne(id);
        return response;
    }

    @PatchMapping("/update")
    public ApiResponse updateALiveStream() {
        ApiResponse response = new ApiResponse();
        response.statusCode = 400;
        response.message = "TBD!";
        response.data = null;
        response.errorCode = 1;
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteALiveStream(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "delete one live stream!";
        response.data = WOWZAStreamBusiness.delete(id);
        return response;
    }

    @PutMapping("/start/{id}")
    public ApiResponse startALiveStream(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "start one live stream!";
        response.data = WOWZAStreamBusiness.start(id);
        return response;
    }

    @PutMapping("/stop/{id}")
    public ApiResponse stopALiveStream(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "stop one live stream!";
        response.data = WOWZAStreamBusiness.stop(id);
        return response;
    }

    @PutMapping("/reset/{id}")
    public ApiResponse resetALiveStream(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "reset one live stream!";
        response.data = WOWZAStreamBusiness.reset(id);
        return response;
    }

    @PutMapping("/regenerateCode/{id}")
    public ApiResponse regenerateConnectionCode(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "regenerate connection code!";
        response.data = WOWZAStreamBusiness.regenerate(id);
        return response;
    }

    @GetMapping("/fetchThumbnail/{id}")
    public ApiResponse fetchThumbnailURL(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "fetch thumbnail!";
        response.data = WOWZAStreamBusiness.fetchThumbnail(id);
        return response;
    }

    @GetMapping("/fetchState/{id}")
    public ApiResponse fetchState(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "fetch state live stream!";
        response.data = WOWZAStreamBusiness.fetchState(id);
        return response;
    }

    @GetMapping("/fetchMetrics/{id}")
    public ApiResponse fetchMetrics(@PathVariable("id") final String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "fetch metrics live stream!";
        response.data = WOWZAStreamBusiness.fetchMetrics(id);
        return response;
    }

    @GetMapping("/versions")
    public ApiResponse getVersionsApi() {
        ApiResponse response = new ApiResponse();
        response.statusCode = 200;
        response.message = "fetch versions live stream!";
        response.data = WOWZAStreamBusiness.fetchVersions();
        return response;

    }

    // testing purppose
    @PostMapping("/target")
    public ApiResponse createCustomStreamTarget(@RequestBody StreamTarget entry) {
        ApiResponse response = new ApiResponse();
        response.statusCode = 200;
        response.message = "created custom live stream!";
        StreamTarget target = WOWZAStreamBusiness.createCustomStreamTarget(entry);
        if(target != null && target.createAt != null){
            response.data = target;
        }
        else {
            response.statusCode = 400;
            response.message = "Bad request!";
        }
        return response;
    }

    @GetMapping("/targets")
    public ApiResponse fetchAllCustomStreamTargets() {
        ApiResponse response = new ApiResponse();
        response.statusCode = 200;
        response.message = "fetch all custom live stream!";
        response.data = WOWZAStreamBusiness.fetchAllCustomStreamTargets();
        return response;
    }

    @GetMapping("/target/{id}")
    public ApiResponse fetchCustomStreamTarget(@PathVariable("id") String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "fetch a custom live stream!";
        response.data = WOWZAStreamBusiness.fetchCustomStreamTarget(id);
        return response;
    }

    @PatchMapping("/target/{id}")
    public ApiResponse updateCustomStreamTarget(@PathVariable("id") String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "update a custom live stream!";
        response.data = WOWZAStreamBusiness.updateCustomStreamTarget(id);
        return response;
    }

    @DeleteMapping("/target/{id}")
    public ApiResponse deleteCustomStreamTarget(@PathVariable("id") String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "delete a custom live stream!";
        response.data = WOWZAStreamBusiness.deleteCustomStreamTarget(id);
        return response;
    }

    @PutMapping("/target/regenerate/{id}")
    public ApiResponse regenerateCodeForAnyStreamTarget(@PathVariable("id") String id) {
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "regenerate code for any custom live stream!";
        response.data = WOWZAStreamBusiness.regenerateCodeForAnyStreamTarget(id);
        return response;
    }

    @GetMapping("/transcoders/{id}")
    public ApiResponse getDefaultTransCoder(@PathVariable("id") String id){
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "the default " + id  + " trans coder information!";
        response.data = WOWZAStreamBusiness.getDefaultTransCoder(id);
        return response;
    }
    @GetMapping("/transcoders/{id}/outputs")
    public ApiResponse fetchAllOutputOfATransCoder(@PathVariable("id") String id){
        ApiResponse response = new ApiResponse();
        if(null == id || "".equals(id)){
            response.statusCode = 400;
            response.message = "ID stream must be not null!";
            response.data = null;
            response.errorCode = 1;
            return response;
        }
        response.statusCode = 200;
        response.message = "all output of trans coder  " + id  + " information!";
        response.data = WOWZAStreamBusiness.fetchAllOutputOfATransCoder(id);
        return response;
    }
    @PostMapping("/transcoders/{transCoderId}/outputs/{outputId}/output_stream_targets/{streamTargetId}")
    public ApiResponse addOutputStreamTargetToTransCoderOfAStream(
            @PathVariable("transCoderId") String transCoderId,
            @PathVariable("outputId") String outputId,
            @PathVariable("streamTargetId") String streamTargetId){
        ApiResponse response = new ApiResponse();
        response.statusCode = 200;
        response.message = "add  output stream to a" +
                " target trans coder of a stream  " + transCoderId + ", " + outputId;
        AdditionOutputStreamTargetToTransCoderEntryParam entry = new AdditionOutputStreamTargetToTransCoderEntryParam();
        entry.streamTargetId = streamTargetId;
        entry.outputId = outputId;
        entry.transCoderId = transCoderId;
        response.data = WOWZAStreamBusiness.addOutputStreamTargetToTransCoderOfAStream(entry);
        return response;
    }

//    @Autowired
//    FacebookLiveBusiness fb;
//    @PostMapping("facebook-live")
//    public ApiResponse addOutputStreamTargetToTransCoderOfAStream(){
//        FacebookConfig fbConfig = new FacebookConfig();
//        return fb.individualCreate(fbConfig);
//    }

}
